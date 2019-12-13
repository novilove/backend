package com.simulacro.services;

import com.simulacro.model.Ingreso_Estudiantes;

public interface IIngresoEstudianteService {
    Ingreso_Estudiantes guardarEstudiante(Ingreso_Estudiantes estudiante);
    Ingreso_Estudiantes buscarId(Long id);
}
