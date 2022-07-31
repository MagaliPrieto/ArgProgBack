package com.argprogmaga.service;

import com.argprogmaga.entity.Study;
import com.argprogmaga.repository.StudyRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService implements IStudyService {

    @Autowired
    public StudyRepository estudioRepo;

    @Override
    public List<Study> verEstudios() {
        return estudioRepo.findAll();
    }

    @Override
    public void crearEstudio(Study est) {
        estudioRepo.save(est);
    }

    @Override
    public void borrarEstudio(Integer id) {
        estudioRepo.deleteById(id);
    }

    @Override
    public Study buscarEstudio(Integer id) {
        return estudioRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarEstudio(Study est) {
        estudioRepo.save(est);
    }
}
