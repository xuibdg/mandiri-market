package com.shop.mandiri_market.repository;

import com.shop.mandiri_market.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MUserRepository extends JpaRepository<MUser, String> {
    Optional<MUser> findByIdAndIsDeletedFalseAndIsActiveTrueAndRole(String id, String role);
}