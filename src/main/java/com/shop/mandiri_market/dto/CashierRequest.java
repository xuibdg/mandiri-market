package com.shop.mandiri_market.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashierRequest {
    private String id;
    private String userId;
    private String phoneNumber;
    private BigDecimal balance;
    private String createdBy;
    private String updatedBy;
}