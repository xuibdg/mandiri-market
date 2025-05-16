package com.shop.mandiri_market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestAttribute(name = "username", required = false) String username) {
        return "Hello, " + (username != null ? username : "Unknown") + "!";
    }
}
