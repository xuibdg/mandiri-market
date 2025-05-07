package com.shop.mandiri_market.dto;

import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private String cashierId;
    private String productId;
    private Integer quantity;
    private BigDecimal nominalAmount;
}
