package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT ps FROM Product ps WHERE ps.isDeleted = false")
    List<Product> findAllIsDeletedFalse();

    @Query("SELECT ps FROM Product ps WHERE ps.id = :id AND ps.isDeleted = false")
    Optional<Product> findByIdAndIsDeletedFalse(String id);
}
