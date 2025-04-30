package com.shop.mandiri_market.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@Builder
public class Transaction {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_id", nullable = false)
    private Cashier cashier;

    @Column(name = "total_buy", nullable = false)
    private BigDecimal totalBuy;

    @Column(nullable = false)
    private BigDecimal paid;

    @Column(name = "change_amount")
    private BigDecimal changeAmount;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    private String status;
}

