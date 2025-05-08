package com.shop.mandiri_market.dto;

import lombok.Data;

@Data
public class OrderPaymentRequest {
    private String description;
    private Double amount;
}
