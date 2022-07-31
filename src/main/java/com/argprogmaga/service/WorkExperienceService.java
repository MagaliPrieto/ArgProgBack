package com.argprogmaga.service;

import com.argprogmaga.entity.WorkExperience;
import com.argprogmaga.repository.WorkExperienceRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService implements IWorkExperienceService {

    @Autowired
    public WorkExperienceRepository expLabRepo;

    @Override
    public List<WorkExperience> verExperienciasLab() {
        return expLabRepo.findAll();
    }

    @Override
    public void crearExperienciaLab(WorkExperience expLab) {
        expLabRepo.save(expLab);
    }

    @Override
    public void borrarExperienciaLab(Integer id) {
        expLabRepo.deleteById(id);
    }

    @Override
    public void mostrarExperienciaLab(Integer id) {
        expLabRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarExperienciaLab(WorkExperience expLab) {
        expLabRepo.save(expLab);
    }
}
