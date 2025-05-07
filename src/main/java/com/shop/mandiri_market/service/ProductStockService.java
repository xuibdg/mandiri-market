package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.ProductStockRequest;
import com.shop.mandiri_market.dto.ProductStockResponse;

import java.util.List;

public interface ProductStockService {
    ProductStockResponse create(ProductStockRequest dto);
    ProductStockResponse update(String id, ProductStockRequest dto);
    void delete(String id);
    ProductStockResponse getById(String id);
    List<ProductStockResponse> getAll();
}
