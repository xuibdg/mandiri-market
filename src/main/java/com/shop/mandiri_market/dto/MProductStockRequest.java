package com.shop.mandiri_market.dto;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MProductStockRequest {
    private String id;
    private String productId;
    private int stock;
    private Timestamp creareAt;
    private Timestamp updateAt;
    private int stockOut;
}
