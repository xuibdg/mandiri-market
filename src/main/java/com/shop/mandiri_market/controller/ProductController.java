package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.ProductRequest;
import com.shop.mandiri_market.dto.ProductResponse;
import com.shop.mandiri_market.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@NoArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    String createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }

    @GetMapping("/get-all")
    List<ProductResponse> getAll(@RequestParam(required = false, defaultValue = "") String name){
        return productService.getAll(name);
    }
}
