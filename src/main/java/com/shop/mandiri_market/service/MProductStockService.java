package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.MProductStockRequest;

import java.util.List;

public interface MProductStockService {
    String createProduct(MProductStockRequest request);
    List<MProductStockService>getAll(String productName);
    String updateProduct(String id , MProductStockRequest request);
    String deleteProduct(String id);

}
