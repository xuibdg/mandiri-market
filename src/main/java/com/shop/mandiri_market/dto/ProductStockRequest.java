package com.shop.mandiri_market.dto;

import lombok.Data;

@Data
public class ProductStockRequest {
    private String productId;
    private Integer stock;
    private Integer stockOut;
    private String createdBy;
    private String updatedBy;
    private boolean isDeleted;
}
