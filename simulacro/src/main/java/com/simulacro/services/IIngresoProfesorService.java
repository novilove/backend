package com.simulacro.services;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.model.IngresoProfesores;

public interface IIngresoProfesorService {
    IngresoProfesores guardarProfesor(ReqDtoCrearProfe profesor) throws Exception;
    IngresoProfesores busrcarId(Long id);

}
