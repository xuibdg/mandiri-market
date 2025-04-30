package com.shop.mandiri_market.dto;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MProductStockResponse {
    private String id;
    private boolean isActive;
    private boolean isDelete;


}
