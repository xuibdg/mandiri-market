package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.ProductRequest;
import com.shop.mandiri_market.dto.ProductResponse;
import com.shop.mandiri_market.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@NoArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    String createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }

    @GetMapping("/get-all")
    List<ProductResponse> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) BigDecimal price){
        return productService.getAll(name, price);
    }

    @PutMapping("/{id}")
    String updateProduct(@PathVariable String id, @RequestBody ProductRequest request){
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
