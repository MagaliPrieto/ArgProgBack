package com.argprogmaga.security.service;

import com.argprogmaga.security.entity.Rol;
import com.argprogmaga.security.enums.RoleName;
import com.argprogmaga.security.repository.RolRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService implements IRoleService {
    @Autowired
    RolRepository rolRepo;

    @Override
    public Optional<Rol> getRolPorNombre(RoleName rolNombre) {
        return this.rolRepo.findByRol(rolNombre);
    }

    @Override
    public void guardarRol(Rol rol) {
        this.rolRepo.save(rol);
    }
}
