package com.argprogmaga.security.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JWToken {
    private String bearer = "Bearer";
    private String token;
    private String email;
    private Collection <?  extends GrantedAuthority> authorities;

    public JWToken(String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }
}
