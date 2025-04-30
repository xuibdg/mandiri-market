package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.ProductStockRequest;
import com.shop.mandiri_market.dto.ProductStockResponse;
import com.shop.mandiri_market.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-stocks")
@RequiredArgsConstructor
public class ProductStockController {

    private final ProductStockService productStockService;

    @PostMapping
    public ResponseEntity<ProductStockResponse> create(@RequestBody ProductStockRequest dto) {
        return ResponseEntity.ok(productStockService.create(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductStockResponse>> getAll() {
        return ResponseEntity.ok(productStockService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductStockResponse> update(@PathVariable String id, @RequestBody ProductStockRequest dto) {
        return ResponseEntity.ok(productStockService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productStockService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStockResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(productStockService.getById(id));
    }


}
