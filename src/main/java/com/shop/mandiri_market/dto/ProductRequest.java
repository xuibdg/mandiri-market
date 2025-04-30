package com.shop.mandiri_market.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String id;
    private String name;
    private BigDecimal price;
}
