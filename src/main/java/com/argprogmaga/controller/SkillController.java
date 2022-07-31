package com.argprogmaga.controller;

import com.argprogmaga.entity.Skill;
import com.argprogmaga.security.entity.AppUser;
import com.argprogmaga.security.service.IUsuarioService;
import com.argprogmaga.service.ISkillService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
@CrossOrigin("*")
public class SkillController {
    @Autowired
    private ISkillService skillServ;

    @Autowired
    private IUsuarioService usuarioServ;

    @PostMapping("/{userId}")
    public ResponseEntity<?> agregarSkill(@PathVariable Integer userId, @RequestBody Skill sk) {
        AppUser user = usuarioServ.buscarUsuario(userId);
        sk.setUser(user);
        skillServ.crearSkill(sk);
        return new ResponseEntity<>("Skill Creada", HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Skill>> verSkills() {
        return new ResponseEntity<>(skillServ.verSkills(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarSkill(@PathVariable Integer id) {
        skillServ.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSkill(@PathVariable Integer id, @RequestBody Skill sk) {
        AppUser user = usuarioServ.buscarUsuario(id);
        sk.setUser(user);
        skillServ.actualizarSkill(sk);
        return new ResponseEntity<>("Skill Actualizada", HttpStatus.OK);
    }
}
