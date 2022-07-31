package com.argprogmaga.util;

import com.argprogmaga.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        /*
        Rol rolAdmin = new Rol(RoleName.ROLE_ADMIN);
        Rol rolUser = new Rol(RoleName.ROLE_USER);
        roleService.guardarRol(rolAdmin);
        roleService.guardarRol(rolUser);
        */
    }
}
