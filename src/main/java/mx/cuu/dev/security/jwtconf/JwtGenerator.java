package mx.cuu.dev.security.jwtconf;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.cuu.dev.security.model.JwtUser;

@Component
public class JwtGenerator {

    private static final String SECRET = "THIS_IS_THE_SECRET";

    public String generate(JwtUser jwtUser) {
        final Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

}
