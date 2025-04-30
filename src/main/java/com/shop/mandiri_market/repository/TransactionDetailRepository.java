package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository  extends JpaRepository<TransactionDetail,String> {
}
