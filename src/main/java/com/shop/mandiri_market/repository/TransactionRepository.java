package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
