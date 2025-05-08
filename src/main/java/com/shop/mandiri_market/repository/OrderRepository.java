package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
