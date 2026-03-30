package com.proj.subscriptionTracker.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String userId) {
        return Jwts.builder()
                .subject(userId)   // NEW
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getSigningKey())  // NEW
                .compact();
    }

    public String validateToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())   // NEW
                .build()
                .parseSignedClaims(token)      // NEW
                .getPayload();

        return claims.getSubject();
    }
}