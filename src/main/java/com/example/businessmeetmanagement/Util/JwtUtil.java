package com.example.businessmeetmanagement.Util;

import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.tokenValidity}")
    private long tokenValidity;

    public String getUsername(String token){
        try{
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return body.getSubject();
        }
        catch (Exception e){
            log.error("Cannot Get Username from Token");
            e.printStackTrace();
        }
        return null;
    }

    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        long currentTimeInMillis = System.currentTimeMillis();
        long expirationInMillis = currentTimeInMillis + tokenValidity;
        Date expDate = new Date(expirationInMillis);
        return Jwts.builder().setClaims(claims)
                .setIssuedAt(new Date(currentTimeInMillis))
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public void validateToken(final String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        }
        catch (SignatureException e){
            log.error("Invalid JWT Signature");
            throw new ResourceNotFoundException("Invalid JWT Signature");
        }
        catch (ExpiredJwtException ex){
            log.error("Invalid Expired Signature");
            throw new ResourceNotFoundException("Expired JWT Token");
        }
        catch (IllegalArgumentException ie){
            log.error("JWT claims is missing");
            throw new ResourceNotFoundException("JWT claims is missing");
        }
    }
}
