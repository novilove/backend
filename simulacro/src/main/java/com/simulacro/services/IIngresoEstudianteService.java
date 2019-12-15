package com.simulacro.services;

import com.simulacro.dto.LlaveIngresoEstudiantes;
import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.model.IngresoEstudiantes;

import java.util.List;

public interface IIngresoEstudianteService {

    IngresoEstudiantes guardarIngresoEstudiante(ReqDtoCrearUsuario estudiante) throws Exception;
    IngresoEstudiantes buscarId(Long id) throws Exception;
    boolean eliminarIngresoEstudiante(Long id) throws Exception;
    List<IngresoEstudiantes> listarIngresoEstudiantes()throws Exception;


}
