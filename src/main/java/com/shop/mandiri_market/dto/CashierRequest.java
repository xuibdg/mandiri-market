package com.shop.mandiri_market.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashierRequest {
    private String userId;
    private String phoneNumber;
    private BigDecimal balance;
    private String createdBy;
}