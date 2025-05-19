package com.tareaflow.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class JwtProvider {

    // 🔐 Clave secreta fija para firmar y verificar tokens (cárgala de un archivo en producción)
    private static final String SECRET = "EstaClaveSuperSecretaParaTareaFlowDebeTenerAlMenos256Bits!!";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRATION_MS = 86400000; // 24 horas

    /**
     * Genera un JWT con subject = UUID del usuario, y un claim adicional con el email
     */
    public static String generateToken(UUID userId, String email) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * Parsea y valida un JWT. Si es inválido o expirado, lanza JwtException
     */
    public static Claims parseToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
