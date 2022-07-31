package com.argprogmaga.service;

import com.argprogmaga.entity.Project;
import com.argprogmaga.repository.ProjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    public ProjectRepository proyectoRepo;

    @Override
    public List<Project> verProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void crearProyecto(Project pro) {
        proyectoRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Integer id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Project buscarProyecto(Integer id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarProyecto(Project pro) {
        proyectoRepo.save(pro);
    }
}
