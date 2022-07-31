package com.argprogmaga.security.repository;

import com.argprogmaga.security.entity.Rol;
import com.argprogmaga.security.enums.RoleName;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRol(RoleName rol);
}
