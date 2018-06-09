package mx.cuu.dev.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {
    
    private static final long serialVersionUID = -2838302112567852219L;
    
    private String username;
    
    private Long id;
    
    private String token;
    
    private List<GrantedAuthority> authorities;
    
    public JwtUserDetails(final String username, final Long id, final String token, final List<GrantedAuthority> authorities) {
        this.username = username;
        this.id = id;
        this.token = token;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

        /**
     * @return the grantedAuthorities
     */
    public List<GrantedAuthority> getGrantedAuthorities() {
        return authorities;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    
}
