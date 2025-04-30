package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.ProductRequest;
import com.shop.mandiri_market.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    String createProduct(ProductRequest request);
    List<ProductResponse> getAll(String name);
}
