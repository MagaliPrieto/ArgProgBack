package com.argprogmaga.security.controller;

import com.argprogmaga.security.dto.JWToken;
import com.argprogmaga.security.dto.LoginUser;
import com.argprogmaga.security.dto.MessageWrapper;
import com.argprogmaga.security.dto.NewUser;
import com.argprogmaga.security.entity.Rol;
import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.enums.RoleName;
import com.argprogmaga.security.jwt.JWTProvider;
import com.argprogmaga.security.service.RoleService;
import com.argprogmaga.security.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    PasswordEncoder passEncoder;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    UsuarioService userService;

    @Autowired
    RoleService rolService;

    @Autowired
    JWTProvider jwtProvider;

    @PostMapping("/user")
    public ResponseEntity<?> nuevoUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new MessageWrapper("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new MessageWrapper("El email ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }

        AppUser appUser = new AppUser(newUser.getEmail(), passEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getRolPorNombre(RoleName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getRolPorNombre(RoleName.ROLE_ADMIN).get());
        }

        appUser.setRoles(roles);
        userService.crearUsuario(appUser);

        return new ResponseEntity(new MessageWrapper("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JWToken> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new MessageWrapper("Campos mal ingresados " + bindingResult), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authManager.authenticate(loginUser.toAuthToken());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JWToken jwtDTO = new JWToken(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
