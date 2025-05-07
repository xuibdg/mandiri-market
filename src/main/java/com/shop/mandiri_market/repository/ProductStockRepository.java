package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Product;
import com.shop.mandiri_market.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductStockRepository extends JpaRepository<ProductStock, String> {
    @Query("SELECT ps FROM ProductStock ps WHERE ps.isDeleted = false")
    List<ProductStock> findAllIsDeletedFalse();

    Optional<ProductStock> findByProductId(String productId);

    @Query("SELECT ps FROM ProductStock ps WHERE ps.id = :id AND ps.isDeleted = false")
    Optional<ProductStock> findByIdAndIsDeletedFalse(String id);
}