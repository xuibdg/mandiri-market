package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.CashierRequest;
import com.shop.mandiri_market.dto.CashierResponse;
import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.MUser;
import com.shop.mandiri_market.repository.CashierRepository;
import com.shop.mandiri_market.repository.MUserRepository;
import com.shop.mandiri_market.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private CashierRepository cashierRepository;

    @Autowired
    private MUserRepository userRepository;

    @Override
    public CashierResponse create(CashierRequest request) {
        MUser user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        if (!"2".equalsIgnoreCase(user.getUserId())){

        }

        Cashier cashier = new Cashier();
        cashier.setId(request.getId());
        cashier.setUser(user);
        cashier.setPhoneNumber(request.getPhoneNumber());
        cashier.setBalance(request.getBalance());
        cashier.setCreatedAt(LocalDateTime.now());
        cashier.setCreatedBy(request.getCreatedBy());

        return toResponse(cashierRepository.save(cashier));
    }

    @Override
    public CashierResponse update(String id, CashierRequest request) {
        Cashier cashier = cashierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cashier tidak ditemukan"));

        cashier.setPhoneNumber(request.getPhoneNumber());
        cashier.setBalance(request.getBalance());
        cashier.setUpdatedAt(LocalDateTime.now());
        cashier.setUpdatedBy(request.getUpdatedBy());

        return toResponse(cashierRepository.save(cashier));
    }

    @Override
    public CashierResponse getById(String id) {
        return cashierRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Cashier tidak ditemukan"));
    }

    @Override
    public List<CashierResponse> getAll() {
        return cashierRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {

        cashierRepository.findById(id).map(data -> {
            data.setDeleted(Boolean.TRUE);
            cashierRepository.save(data);

            Cashier cashier = cashierRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cashier tidak ditemukan"));
            cashierRepository.delete(cashier);
            return data;
        });
    }

    private CashierResponse toResponse(Cashier entity) {
        CashierResponse dto = new CashierResponse();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setBalance(entity.getBalance());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }
}