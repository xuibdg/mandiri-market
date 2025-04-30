package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, String> {
}
