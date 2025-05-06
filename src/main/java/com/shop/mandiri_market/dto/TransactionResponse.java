package com.shop.mandiri_market.dto;

import com.shop.mandiri_market.entity.Cashier;
import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.Transaction;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private String cashierId;
    private String productId;
    private BigDecimal totalBuy;
    private BigDecimal  paid;
    private BigDecimal changeAmount;
    private Timestamp createdAt;
    private String transactionId;
    private Integer quantity;
    private String status;
}
