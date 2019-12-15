package com.simulacro.services;

import com.simulacro.dto.LlaveIngresoEstudiantes;
import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.model.IngresoEstudiantes;

import java.util.List;

public interface IIngresoEstudianteService {

    IngresoEstudiantes guardarEstudiante(ReqDtoCrearUsuario estudiante) throws Exception;
    IngresoEstudiantes buscarId(Long id) throws Exception;
    boolean eliminarEstudiante(Long id) throws Exception;
    List<IngresoEstudiantes> listarEstudiantes()throws Exception;


}
