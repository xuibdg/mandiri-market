package com.shop.mandiri_market.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MUserRequest {
    private String name;
    private String email;
    private String password;
    private String roleId;

}
