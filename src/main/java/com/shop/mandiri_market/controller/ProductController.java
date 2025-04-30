package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.ProductRequest;
import com.shop.mandiri_market.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    String createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }
}
