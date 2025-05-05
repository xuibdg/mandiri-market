package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductStockRepository extends JpaRepository<ProductStock, String> {
    Optional<ProductStock> findByProductId(String productId);
}
