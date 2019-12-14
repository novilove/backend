package com.simulacro.services;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.model.IngresoProfesores;

public interface IIngresoProfesorService {
    IngresoProfesores guardarProfesor(ReqDtoCrearProfe profesor);
    IngresoProfesores busrcarId(Long id);

}
