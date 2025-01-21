package com.hms.ms_user.infraestructure.security.auth;

import com.hms.ms_user.applications.dtos.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class JwtService {

    private static final String secretKeyFull = "chave-secreta-que-123456789-irei-atualizar";
    private static final Key secretKey = Keys.hmacShaKeyFor(secretKeyFull.getBytes());

    public String generateToken(String username, String password, Date expiresAt) {

        Map<String, Object> claims = new HashMap<>();
        // TODO isso ainda sera implementado. Sistema de seguranca para validar username e password.
        claims.put("username", username);
        claims.put("password", password);
        claims.put("role", "ADMIN");

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(secretKey)
                .compact();
    }

    public AuthResponse login(String username, String password) {
        Date expiresAt = new Date(System.currentTimeMillis() + 30000);
        String token = generateToken(username, password, expiresAt);

        return AuthResponse.builder()
                .type("Bearer")
                .accessToken(token)
                .expiresAt(expiresAt.getTime())
                .build();
    }

}
