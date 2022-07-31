package com.argprogmaga.security.jwt;

import com.argprogmaga.security.entity.PrimaryUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JWTProvider {
    private final static Logger logger = LoggerFactory.getLogger(JWTProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication auth) {
        PrimaryUser user = (PrimaryUser) auth.getPrincipal();

        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException jwtEx) {
            logger.error("MalformedJwtException: " + jwtEx.getMessage());
        } catch (UnsupportedJwtException jwtEx) {
            logger.error("UnsupportedJwtException: " + jwtEx.getMessage());
        } catch (ExpiredJwtException jwtEx) {
            logger.error("ExpiredJwtException: " + jwtEx.getMessage());
        } catch (IllegalArgumentException jwtEx) {
            logger.error("IllegalArgumentException: " + jwtEx.getMessage());
        } catch (SignatureException jwtEx) {
            logger.error("SignatureException: " + jwtEx.getMessage());
        }

        return false;
    }
}
