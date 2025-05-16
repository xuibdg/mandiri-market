package com.shop.mandiri_market.controller;

import com.shop.mandiri_market.dto.MUserRequest;
import com.shop.mandiri_market.dto.MUserResponse;
import com.shop.mandiri_market.service.MUserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@NoArgsConstructor
public class MUserController {

    @Autowired
    private MUserService mUserService;


    @PostMapping
    String createUser(@RequestBody MUserRequest request){
        return mUserService.createUser(request);
    }


    @GetMapping("/get-all")
    List<MUserResponse> getAll(@RequestParam(required = false, defaultValue = "") String name){
        return mUserService.getAll(name);
    }


    @PutMapping("/{id}")
    String updateUser(@PathVariable String id, @RequestBody MUserRequest request){
        return mUserService.updateUser(id, request);
    }


    @DeleteMapping("/{id}")
    String deletedUser(@PathVariable String id){
        return mUserService.deletedUser(id);
    }



}
