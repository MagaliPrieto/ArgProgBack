package com.argprogmaga.security.service;

import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.repository.AppUserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    private AppUserRepository usuarioRepo;

    @Override
    public List<AppUser> verUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void crearUsuario(AppUser user) {
        usuarioRepo.save(user);
    }

    @Override
    public void borrarUsuario(Integer id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public AppUser buscarUsuario(Integer id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarUsuario(AppUser user) {
        usuarioRepo.save(user);
    }

    @Override
    public Optional<AppUser> getByMail(String email) {
        return usuarioRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }
}
