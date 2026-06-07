package me.spring.security;

import io.jsonwebtoken.*;
import me.spring.config.JwtConfig;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * JWT token provider — generates and validates access/refresh tokens.
 */
@Component
public class JwtTokenProvider {

    private final SecretKey key;
    private final long expiration;
    private final long refreshExpiration;

    public JwtTokenProvider(JwtConfig jwtConfig) {
        this.key = jwtConfig.jwtSecretKey();
        this.expiration = jwtConfig.getExpiration();
        this.refreshExpiration = jwtConfig.getRefreshExpiration();
    }

    /** Generate access token with username and role in claims. */
    public String generateAccessToken(String username, String role) {
        return Jwts.builder()
            .subject(username)
            .claim("role", role)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact();
    }

    /** Generate long-lived refresh token. */
    public String generateRefreshToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + refreshExpiration))
            .signWith(key)
            .compact();
    }

    /** Extract username from token. */
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    /** Validate token signature and expiration. */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
