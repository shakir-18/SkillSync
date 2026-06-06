package com.hackathon.SkillSync.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET =
            "myskillsyncsecretkeymyskillsyncsecretkey";

    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){

        return Jwts.parserBuilder()
                .setSigningKey(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){

        try{
            extractUsername(token);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public String extractEmail(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extractRole(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }
}
