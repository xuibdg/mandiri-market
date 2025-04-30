package com.shop.mandiri_market.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MCashierResponse {
    private String id;
    private String userId;
    private String userName; // Jika kamu ingin tampilkan nama user
    private String phoneNumber;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}