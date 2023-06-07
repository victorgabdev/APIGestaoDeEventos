package com.victorgabriel.eventos.shared.security;

import com.victorgabriel.eventos.modules.customers.dto.JWTToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenConfig {

    public static JWTToken encode(TokenInfo tokenInfo) {
        String secretKey = "AppEventsSpringBootAppEventsSpringBoot";
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        String jwt = Jwts.builder()
                        .setSubject(tokenInfo.getSubject())  // passar usuario
                        .setIssuer("EVENTS_APP")  // passar quem é o emissor
                        .setExpiration(tokenInfo.getExpiresIn())  // Definir tempo de expiraçao
                        .signWith(key, SignatureAlgorithm.HS256)   // passar uma assinatura
                        .compact();

        return new JWTToken("Bearer " + jwt);
    }
}
