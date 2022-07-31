package com.argprogmaga.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter @Setter
@AllArgsConstructor
public class LoginUser {
    @Email  
    private String email;
    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken toAuthToken() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
