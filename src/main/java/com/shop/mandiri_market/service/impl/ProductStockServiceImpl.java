package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.ProductStockRequest;
import com.shop.mandiri_market.dto.ProductStockResponse;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.ProductStock;
import com.shop.mandiri_market.repository.ProductRepository;
import com.shop.mandiri_market.repository.ProductStockRepository;
import com.shop.mandiri_market.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {

    private final ProductStockRepository productStockRepository;
    private final ProductRepository productRepository;

    @Override
    public ProductStockResponse create(ProductStockRequest dto) {
        Product product = productRepository.findByIdAndIsDeletedFalse(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Produk tidak aktif atau tidak ditemukan."));

        ProductStock stock = new ProductStock();
        stock.setId(UUID.randomUUID().toString());
        stock.setProduct(product);
        stock.setStock(dto.getStock());
        stock.setStockOut(dto.getStockOut());
        stock.setCreatedAt(LocalDateTime.now());
        stock.setCreatedBy(dto.getCreatedBy());

        productStockRepository.save(stock);
        return toResponse(stock);
    }

    @Override
    public List<ProductStockResponse> getAll() {
        return productStockRepository.findAllIsDeletedFalse()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductStockResponse getById(String id) {
        ProductStock stock = productStockRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("stok produk tidak ditemukan"));
        return toResponse(stock);
    }

    @Override
    public ProductStockResponse update(String id, ProductStockRequest dto) {
        ProductStock stock = productStockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock Produk tidak ditemukan."));

        Product product = productRepository.findByIdAndIsDeletedFalse(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("produk tidak ditemukan."));

        stock.setProduct(product);
        stock.setStock(dto.getStock());
        stock.setStockOut(dto.getStockOut());
        stock.setUpdatedAt(LocalDateTime.now());
        stock.setUpdatedBy(dto.getUpdatedBy());
        stock.setDeleted(dto.isDeleted());

        productStockRepository.save(stock);
        return toResponse(stock);
    }

    @Override
    public void delete(String id) {
        ProductStock stock = productStockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("stok produk tidak ditemukan"));
        stock.setDeleted(true);
        stock.setUpdatedAt(LocalDateTime.now());
        productStockRepository.save(stock);
    }

    private ProductStockResponse toResponse(ProductStock stock) {
        ProductStockResponse dto = new ProductStockResponse();
        dto.setId(stock.getId());
        dto.setProductId(stock.getProduct().getId());
        dto.setStock(stock.getStock());
        dto.setStockOut(stock.getStockOut());
        dto.setCreatedBy(stock.getCreatedBy());
        dto.setUpdatedBy(stock.getUpdatedBy());
        dto.setDeleted(stock.isDeleted());
        return dto;
    }
}
