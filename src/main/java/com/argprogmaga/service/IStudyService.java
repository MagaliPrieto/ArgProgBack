package com.argprogmaga.service;

import com.argprogmaga.entity.Study;

import java.util.List;

public interface IStudyService {
    List<Study> verEstudios();

    void crearEstudio(Study est);

    void borrarEstudio(Integer id);

    Study buscarEstudio(Integer id);

    void actualizarEstudio(Study est);
}
