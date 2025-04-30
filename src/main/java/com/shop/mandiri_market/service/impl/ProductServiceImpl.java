package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.ProductRequest;
import com.shop.mandiri_market.dto.ProductResponse;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.repository.ProductRepository;
import com.shop.mandiri_market.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public String createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCreatedAt(LocalDateTime.now());

        return "SUCCESS ADD PRODUCT";

    }

    @Override
    public List<ProductResponse> getAll(String name) {

        List<ProductResponse> list = productRepository.findByName(name).stream().map(data -> {
            return ProductResponse.builder()
                    .Id(data.getId())
                    .name(data.getName())
                    .price(data.getPrice())
                    .build();
        }).collect(Collectors.toList());

        return list;
    }


}
