package com.argprogmaga.security.controller;

import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.service.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioServ;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AppUser>> verUsuarios() {
        return new ResponseEntity<>(usuarioServ.verUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarUsuario(@PathVariable Integer id) {
        usuarioServ.borrarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody AppUser user) {
        usuarioServ.actualizarUsuario(user);
        return new ResponseEntity<>("User Actualizado!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AppUser> verUsuarioID(@PathVariable Integer id) {
        return new ResponseEntity<>(usuarioServ.buscarUsuario(id), HttpStatus.OK);
    }
}
