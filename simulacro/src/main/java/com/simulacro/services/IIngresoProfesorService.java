package com.simulacro.services;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.model.IngresoEstudiantes;
import com.simulacro.model.IngresoProfesores;

import java.util.List;

public interface IIngresoProfesorService {
    IngresoProfesores guardarIngresoProfesor(ReqDtoCrearProfe profesor) throws Exception;
    IngresoProfesores busrcarId(Long id) throws Exception;
    boolean eliminarIngresoProfesor(Long id) throws Exception;
    List<IngresoProfesores> listarIngresoProfesor()throws Exception;

}
