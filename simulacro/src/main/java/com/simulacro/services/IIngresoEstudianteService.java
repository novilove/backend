package com.simulacro.services;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.model.IngresoEstudiantes;

public interface IIngresoEstudianteService {

    IngresoEstudiantes guardarEstudiante(ReqDtoCrearUsuario estudiante) throws Exception;
    IngresoEstudiantes buscarId(Long id) throws Exception;




    boolean eliminarEstudiante(Long id);

}
