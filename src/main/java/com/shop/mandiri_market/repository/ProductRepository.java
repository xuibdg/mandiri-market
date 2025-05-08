package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT ps FROM Product ps WHERE ps.isDeleted = false")
    List<Product> findAllIsDeletedFalse();

    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.isDeleted = false")
    List<Product> findByIsDeletedFalse(String id);

    @Query("SELECT ps FROM Product ps WHERE ps.id = :id AND ps.isDeleted = false")
    Optional<Product> findByIdAndIsDeletedFalse(String id);


    @Query(value = "select * from product where (:name = '' or :name is null or product.\"name\" like concat('%', :name, '%'))\n" +
            "and (:price is null or product.price = :price) \n" +
            "and is_deleted is false", nativeQuery = true)
    List<Product> findByNameAndPrice(String name, BigDecimal price);
}
