package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    /*@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    List<Product> findByName(String name);*/
    //List<Product> findByIsDeleted(String name);
    @Query("SELECT p FROM Product p WHERE p.isDeleted = false")
    List<Product> findByIsDeletedFalse(String id);
}
