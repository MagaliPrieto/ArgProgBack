package com.argprogmaga.controller;

import com.argprogmaga.entity.Project;
import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.service.IUsuarioService;
import com.argprogmaga.service.IProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUsuarioService usuarioServ;

    @PostMapping("/{userId}")
    public ResponseEntity<?> agregarProyecto(@PathVariable Integer userId, @RequestBody Project pro) {
        AppUser user = usuarioServ.buscarUsuario(userId);
        pro.setUser(user);
        projectService.crearProyecto(pro);
        return new ResponseEntity<>("Proyecto Creado", HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Project>> verProyectos() {
        return new ResponseEntity<>(projectService.verProyectos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarProyecto(@PathVariable Integer id) {
        projectService.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProyecto(@PathVariable Integer id, @RequestBody Project pro) {
        AppUser user = usuarioServ.buscarUsuario(id);
        pro.setUser(user);
        projectService.actualizarProyecto(pro);
        return new ResponseEntity<>("Poyecto Actualizado", HttpStatus.OK);
    }
}
