package com.argprogmaga.service;

import com.argprogmaga.entity.WorkExperience;

import java.util.List;

public interface IWorkExperienceService {
    List<WorkExperience> verExperienciasLab();

    void crearExperienciaLab(WorkExperience expLab);

    void borrarExperienciaLab(Integer id);

    void mostrarExperienciaLab(Integer id);

    void actualizarExperienciaLab(WorkExperience expLab);
}
