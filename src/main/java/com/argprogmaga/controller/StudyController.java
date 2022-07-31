package com.argprogmaga.controller;

import com.argprogmaga.entity.Study;
import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.service.IUsuarioService;
import com.argprogmaga.service.IStudyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studies")
@CrossOrigin("*")
public class StudyController {
    @Autowired
    private IStudyService estudioServ;

    @Autowired
    private IUsuarioService usuarioServ;

    @PostMapping("/{userId}")
    public ResponseEntity<?> agregarEstudio(@PathVariable Integer userId, @RequestBody Study est) {
        AppUser user = usuarioServ.buscarUsuario(userId);
        est.setUser(user);
        estudioServ.crearEstudio(est);
        return new ResponseEntity<>("Estudio Creado", HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Study>> verEstudios() {
        return new ResponseEntity<>(estudioServ.verEstudios(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarEstudio(@PathVariable() Integer id) {
        estudioServ.borrarEstudio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstudio(@PathVariable Integer id, @RequestBody Study est) {
        AppUser user = usuarioServ.buscarUsuario(id);
        est.setUser(user);
        estudioServ.actualizarEstudio(est);
        return new ResponseEntity<>("Estudio Actualizado", HttpStatus.OK);
    }
}
