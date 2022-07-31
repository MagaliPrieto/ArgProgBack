package com.argprogmaga.service;

import com.argprogmaga.entity.Skill;
import com.argprogmaga.repository.SkillRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {

    @Autowired
    public SkillRepository skillRepo;

    @Override
    public List<Skill> verSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void crearSkill(Skill sk) {
        skillRepo.save(sk);
    }

    @Override
    public void borrarSkill(Integer id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Integer id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarSkill(Skill sk) {
        skillRepo.save(sk);
    }
}
