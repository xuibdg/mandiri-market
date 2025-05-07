package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.ProductStockRequest;
import com.shop.mandiri_market.dto.ProductStockResponse;
import com.shop.mandiri_market.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-stocks")
@RequiredArgsConstructor
public class ProductStockController {

    private final ProductStockService productStockService;

    @PostMapping
    public ProductStockResponse create(@RequestBody ProductStockRequest dto) {
        return productStockService.create(dto);
    }

    @GetMapping("/all")
    public List<ProductStockResponse> getAll() {
        return productStockService.getAll();
    }

    @PutMapping("/{id}")
    public ProductStockResponse update(@PathVariable String id, @RequestBody ProductStockRequest dto) {
        return productStockService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        productStockService.delete(id);
        return "Delete Success.";
    }

    @GetMapping("/{id}")
    public ProductStockResponse getById(@PathVariable String id) {
        return productStockService.getById(id);
    }


}
