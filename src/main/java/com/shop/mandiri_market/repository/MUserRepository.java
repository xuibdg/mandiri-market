package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MUserRepository extends JpaRepository<MUser, String> {

    @Query("SELECT mu FROM MUser mu WHERE mu.name LIKE CONCAT('%', :name, '%')")
    List<MUser> findByName(String name);
}
