package com.shop.mandiri_market.dto;

import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Cashier cashierId;
    private Product productId;
    private BigDecimal totalBuy;
    private BigDecimal  paid;
    private BigDecimal changeAmount;
    private LocalDateTime createdAt;
    private Transaction transactionid;
    private Integer quantity;
    private String status;
}
