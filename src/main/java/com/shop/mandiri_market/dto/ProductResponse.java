package com.shop.mandiri_market.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String Id;
    private String name;
    private BigDecimal price;
}
