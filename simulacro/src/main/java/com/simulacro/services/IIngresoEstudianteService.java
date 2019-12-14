package com.simulacro.services;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.model.IngresoEstudiantes;

public interface IIngresoEstudianteService {

    IngresoEstudiantes guardarEstudiante(ReqDtoCrearUsuario estudiante);
    IngresoEstudiantes buscarId(Long id);




    boolean eliminarEstudiante(Long id);

}
