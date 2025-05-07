package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.MUser;
import com.shop.mandiri_market.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT t FROM Transaction t WHERE t.cashier.user.name = :name")
    List<Transaction> findByName(@Param("name") String name);
}
