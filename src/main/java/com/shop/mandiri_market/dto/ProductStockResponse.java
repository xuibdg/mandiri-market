package com.shop.mandiri_market.dto;

import lombok.Data;

@Data
public class ProductStockResponse {
    private String id;
    private String productId;
    private Integer stock;
    private Integer stockOut;
    private String createdBy;
    private String updatedBy;
    private boolean isDeleted;
}
