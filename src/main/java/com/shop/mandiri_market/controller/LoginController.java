package com.shop.mandiri_market.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static final String SECRET_KEY = "mysecretkey12345678901234567890123456789012"; // 256-bit
    private static final long EXPIRATION_TIME = 3600000; // 1 jam

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        // NOTE: ganti ini dengan validasi database atau service real
        if ("admin".equals(username) && "1234".equals(password)) {

            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

            String jwt = Jwts.builder()
                    .setSubject(username)
                    .setIssuer("myapp")
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return response;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
