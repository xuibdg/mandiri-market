package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.CashierRequest;
import com.shop.mandiri_market.dto.CashierResponse;

import java.util.List;

public interface CashierService {
    CashierResponse create(CashierRequest request);
    CashierResponse update(String id, CashierRequest request);
    CashierResponse getById(String id);
    List<CashierResponse> getAll();
    void delete(String id);
}