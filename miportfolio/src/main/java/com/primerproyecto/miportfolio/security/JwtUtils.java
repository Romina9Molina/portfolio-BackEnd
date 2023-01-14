package com.primerproyecto.miportfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class JwtUtils {

    private final static String ACCESS_TOKEN = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud"; // llamar esto por properties a futuro
    //private final static String ACCESS_TOKEN = "Abuelitadimetu"; // llamar esto por properties a futuro
    private final static Long ACCESS_TOKE_VALIDITY_SECONDS = 2_592_000l;



    public static String createToken(String username){

        long expirationTime = ACCESS_TOKE_VALIDITY_SECONDS * 1_000;
        Date expiration = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN.getBytes()))
                .compact();
    }

    //se utiliza para desencriptar el token con el access tocken creado
    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
       try {
           Claims claims = Jwts.parserBuilder()
                   .setSigningKey(ACCESS_TOKEN.getBytes())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
           String username = claims.getSubject();

           return new UsernamePasswordAuthenticationToken(username,null, Collections.emptyList());
       }catch (JwtException e){
           return null;
       }
    }



}
