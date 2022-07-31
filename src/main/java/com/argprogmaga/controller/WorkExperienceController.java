package com.argprogmaga.controller;

import com.argprogmaga.entity.WorkExperience;
import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.service.IUsuarioService;
import com.argprogmaga.service.IWorkExperienceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiences")
@CrossOrigin("*")
public class WorkExperienceController {
    @Autowired
    private IWorkExperienceService experienciaLabServ;

    @Autowired
    private IUsuarioService usuarioServ;

    @PostMapping("/{userId}")
    public ResponseEntity<?> agregarExperienciaLab(@PathVariable Integer userId, @RequestBody WorkExperience expLab) {
        AppUser user = usuarioServ.buscarUsuario(userId);
        expLab.setUser(user);
        experienciaLabServ.crearExperienciaLab(expLab);
        return new ResponseEntity<>("Experiencia de Trabajo Creada", HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<WorkExperience>> verExperienciasLab() {
        return new ResponseEntity<>(experienciaLabServ.verExperienciasLab(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarExperiencia(@PathVariable Integer id) {
        experienciaLabServ.borrarExperienciaLab(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarExperiencia(@PathVariable Integer id, @RequestBody WorkExperience expLab) {
        AppUser user = usuarioServ.buscarUsuario(id);
        expLab.setUser(user);
        experienciaLabServ.actualizarExperienciaLab(expLab);
        return new ResponseEntity<>("Experiencia de Trabajo Actualizada", HttpStatus.OK);
    }
}
