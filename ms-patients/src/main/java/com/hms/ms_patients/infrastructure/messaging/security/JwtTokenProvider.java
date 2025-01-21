package com.hms.ms_patients.infrastructure.messaging.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtTokenProvider {

    //private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Chave secreta gerada automaticamente
    private static final String secretKeyFull = "chave-secreta-que-123456789-irei-atualizar";
    private static final Key secretKey = Keys.hmacShaKeyFor(secretKeyFull.getBytes());
    private final long expirationTime = 3600000; // 1 hora em milissegundos

    // 1. Geração do token
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username) // Define o usuário como o "subject" do token
                .claim("role", role) // Adiciona o perfil como um claim
                .setIssuedAt(new Date()) // Data de emissão
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Data de expiração
                .signWith(secretKey) // Assinatura com a chave secreta
                .compact();
    }

    // 2. Validação do token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true; // Se não ocorrer nenhuma exceção, o token é válido
        } catch (JwtException | IllegalArgumentException e) {
            // Captura qualquer erro de validação
            return false;
        }
    }

    // 3. Extração do username (subject) do token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 4. Extração do perfil (role) do token
    public String getRoleFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public Authentication getAuthentication(String token) {
        // Extrai as informações do token
        String username = getUsernameFromToken(token); // Nome do usuário
        String role = getRoleFromToken(token); // Perfil do usuário

        // Cria uma lista de autoridades baseada no perfil
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);

        // Retorna um objeto Authentication para o Spring Security
        return new UsernamePasswordAuthenticationToken(
                username, // Principal (nome do usuário)
                null, // Credenciais (não usadas com JWT)
                Collections.singletonList(authority) // Lista de roles/authorities
        );
    }
}
