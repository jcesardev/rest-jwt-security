package mx.cuu.dev.security.jwtconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mx.cuu.dev.security.model.JwtUser;

@Component
public class JwtValidator {

    private static final Logger LOG = LoggerFactory.getLogger(JwtValidator.class);

    private static final String SECRET = "THIS_IS_THE_SECRET";

    public JwtUser validate(final String token) {
        JwtUser jwtUser = null;
        try {
            final Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch (final Exception e) {
            LOG.error("An error occurred.", e);
        }
        return jwtUser;
    }

}
