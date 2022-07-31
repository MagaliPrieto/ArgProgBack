package com.argprogmaga.service;

import com.argprogmaga.entity.Project;

import java.util.List;

public interface IProjectService {
    List<Project> verProyectos();

    void crearProyecto(Project pro);

    void borrarProyecto(Integer id);

    Project buscarProyecto(Integer id);

    void actualizarProyecto(Project pro);
}
