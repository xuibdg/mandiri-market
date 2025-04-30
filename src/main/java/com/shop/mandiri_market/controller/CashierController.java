package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.CashierRequest;
import com.shop.mandiri_market.dto.CashierResponse;
import com.shop.mandiri_market.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cashiers")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    @PostMapping
    public CashierResponse create(@RequestBody CashierRequest request) {
        return cashierService.create(request);
    }

    @PutMapping()
    public CashierResponse update(@PathVariable String id, @RequestBody CashierRequest request) {
        return cashierService.update(id, request);
    }

    @GetMapping()
    public CashierResponse getById(@PathVariable String id) {
        return cashierService.getById(id);
    }

    @GetMapping
    public List<CashierResponse> getAll() {
        return cashierService.getAll();
    }

    @DeleteMapping()
    public void delete(@PathVariable String id) {
        cashierService.delete(id);
    }
}