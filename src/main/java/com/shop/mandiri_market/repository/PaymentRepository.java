package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


}
