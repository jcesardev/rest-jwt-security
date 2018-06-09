package mx.cuu.dev.security.jwtconf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import mx.cuu.dev.security.model.JwtAuthenticationToken;
import mx.cuu.dev.security.model.JwtUser;
import mx.cuu.dev.security.model.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
            final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    }
    
    @Override
    public boolean supports(final Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

    

    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        String token = jwtAuthenticationToken.getToken();

        JwtUser jwtUser = jwtValidator.validate(token);

        if (jwtUser == null) {
            throw new RuntimeException("The token is incorrect.");
        }
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(), token, grantedAuthorities);
    }

}
