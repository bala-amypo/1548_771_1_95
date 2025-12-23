package com.example.demo.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private final Key key;

    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(
            "my-super-secret-jwt-key-which-is-at-least-32-characters-long"
                .getBytes()
        );
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 day

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
