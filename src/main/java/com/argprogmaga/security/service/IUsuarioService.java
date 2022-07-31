package com.argprogmaga.security.service;

import com.argprogmaga.security.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<AppUser> verUsuarios();

    void crearUsuario(AppUser user);

    void borrarUsuario(Integer id);

    AppUser buscarUsuario(Integer id);

    void actualizarUsuario(AppUser user);

    Optional<AppUser> getByMail(String email);

    boolean existsByEmail(String email);
}
