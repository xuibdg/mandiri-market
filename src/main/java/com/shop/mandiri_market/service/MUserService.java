package com.shop.mandiri_market.service;

import com.shop.mandiri_market.dto.MUserRequest;
import com.shop.mandiri_market.dto.MUserResponse;

import java.util.List;

public interface MUserService {

    String createUser(MUserRequest request);
    List<MUserResponse> getAll(String name);
    String updateUser(String id, MUserRequest request);
    String deletedUser(String id);
}
