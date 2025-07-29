package com.teste.solution.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.teste.solution.user.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.expiration}")
    private Integer expirationToken;

    private static final String ISSUER = "Solution TI - Teste Processo Seletivo API Security Token Service";

    public String getToken(User user){
        return generateToken(user, expirationToken);
    }

    private String generateToken(User user, Integer expiration){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId().toString())
                    .withExpiresAt(expirationDateToken(expiration))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error generating token", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Invalid or expired token: " +tokenJWT);
        }
    }

    private Instant expirationDateToken(Integer expiration) {
        return LocalDateTime.now().plusHours(expiration).toInstant(ZoneOffset.of("-03:00"));
    }
}
