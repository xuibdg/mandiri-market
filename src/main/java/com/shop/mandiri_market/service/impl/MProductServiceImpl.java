package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.MProductStockRequest;
import com.shop.mandiri_market.service.MProductStockService;

import java.util.List;

public class MProductServiceImpl implements MProductStockService {
    @Override
    public String createProduct(MProductStockRequest request) {
        return "";
    }

    @Override
    public List<MProductStockService> getAll(String productName) {
        return List.of();
    }

    @Override
    public String updateProduct(String id, MProductStockRequest request) {
        return "";
    }

    @Override
    public String deleteProduct(String id) {
        return "";
    }
}