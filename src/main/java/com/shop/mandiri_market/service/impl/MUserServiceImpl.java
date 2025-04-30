package com.shop.mandiri_market.service.impl;

import com.shop.mandiri_market.dto.MUserRequest;
import com.shop.mandiri_market.dto.MUserResponse;
import com.shop.mandiri_market.entity.MUser;
import com.shop.mandiri_market.entity.UserRole;
import com.shop.mandiri_market.repository.MUserRepository;
import com.shop.mandiri_market.repository.UserRoleRepository;
import com.shop.mandiri_market.service.MUserService;
import com.shop.mandiri_market.utils.exception.BusinessException;
import com.shop.mandiri_market.utils.exception.GlobalErrorMapping;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MUserServiceImpl implements MUserService {

    @Autowired
    MUserRepository mUserRepository;

    @Autowired
    UserRoleRepository userRoleRepository;


    @Override
    public String createUser(MUserRequest request) {

        UserRole userRole = userRoleRepository.findById(request.getRoleId()).orElseThrow(() ->  new BusinessException(HttpStatus.BAD_REQUEST, GlobalErrorMapping.RULE_NOT_FOUND));
        MUser mUser = MUser.builder()
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .createdAt(Timestamp.from(Instant.now()))
                .userRole(userRole)
                .build();

        mUserRepository.save(mUser);
        return "SUCCESS CREATED USER";
    }

    @Override
    public List<MUserResponse> getAll(String name) {

        List<MUserResponse> list = mUserRepository.findByName(name).stream().map(data -> {
            return MUserResponse.builder().userId(data.getUserId())
                    .name(data.getName())
                    .email(data.getEmail())
                    .createdAt(Timestamp.from(Instant.now()))
                    .roleName(data.getUserRole().getRoleName()).build();
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public String updateUser(String id, MUserRequest request) {
        mUserRepository.findById(id).map(data -> {
            UserRole userRole = userRoleRepository.findById(request.getRoleId()).orElseThrow(() ->  new BusinessException(HttpStatus.BAD_REQUEST, GlobalErrorMapping.RULE_NOT_FOUND));
            data.setName(request.getName());
            data.setEmail(request.getEmail());
            data.setPassword(request.getPassword());
            data.setUserRole(userRole);
            data.setUpdatedAt(Timestamp.from(Instant.now()));
            mUserRepository.save(data);
            return data;
        });

        return "SUCCESS UPDATED";
    }

    @Override
    public String deletedUser(String id) {
        mUserRepository.findById(id).map(data -> {
            data.setIsDeleted(Boolean.TRUE);
            mUserRepository.save(data);
            return data;
        });

        return "SUCCESS DELETED";
    }
}
