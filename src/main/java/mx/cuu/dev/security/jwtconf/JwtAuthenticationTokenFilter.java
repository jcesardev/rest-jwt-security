package mx.cuu.dev.security.jwtconf;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import mx.cuu.dev.security.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    
    private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    public JwtAuthenticationTokenFilter() {
        super("/rest/**");
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        final String header = httpServletRequest.getHeader("Authorization");
        
        if(header == null || !header.startsWith("Token ")) {
            throw new RuntimeException("JWT Token is missing.");
        }
        String authenticationToken = header.substring(6);
        LOG.info("Authentication JWT Token is: {}", authenticationToken);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
    
    

}
