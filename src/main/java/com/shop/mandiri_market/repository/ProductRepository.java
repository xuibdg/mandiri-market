package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
