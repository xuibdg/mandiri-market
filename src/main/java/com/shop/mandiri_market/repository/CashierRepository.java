package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, String> {
}