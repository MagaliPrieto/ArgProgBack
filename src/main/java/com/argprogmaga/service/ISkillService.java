package com.argprogmaga.service;

import com.argprogmaga.entity.Skill;

import java.util.List;

public interface ISkillService {
    List<Skill> verSkills();

    void crearSkill(Skill sk);

    void borrarSkill(Integer id);

    Skill buscarSkill(Integer id);

    void actualizarSkill(Skill sk);
}
