package com.argprogmaga.security.service;

import com.argprogmaga.security.entity.Rol;
import com.argprogmaga.security.enums.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Rol> getRolPorNombre(RoleName rolNombre);

    void guardarRol(Rol rol);
}
