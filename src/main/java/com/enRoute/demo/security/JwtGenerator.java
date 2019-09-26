package com.enRoute.demo.security;

import com.enRoute.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 *
 * @author JODY
 */
@Component
public class JwtGenerator {


    public String generate(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getEmail1());
        claims.put("userId", String.valueOf(user.getId()));
        claims.put("role", user.getPermission());
        
            return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "kulula")
                .compact();
         

         //return Jwts.parser().setSigningKey("kulula").parse(jws);
        
    }
}
