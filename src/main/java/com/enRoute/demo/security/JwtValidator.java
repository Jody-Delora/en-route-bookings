package com.enRoute.demo.security;

import com.enRoute.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 *
 * @author JODY
 */
@Component
public class JwtValidator {


    private String secret = "kulula";

    public User validate(String token) {

        User user = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();

            user.setEmail1(body.getSubject());
            user.setId(Long.parseLong((String) body.get("userId")));
            user.setPermission((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }
}

