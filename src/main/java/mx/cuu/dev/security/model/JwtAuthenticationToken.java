package mx.cuu.dev.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = -6771460502958717681L;

    private String token;

    public JwtAuthenticationToken(final String token) {
        super(null, null);
        this.token = token;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(final String token) {
        this.token = token;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.authentication.UsernamePasswordAuthenticationToken#getCredentials()
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.authentication.UsernamePasswordAuthenticationToken#getPrincipal()
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

}
