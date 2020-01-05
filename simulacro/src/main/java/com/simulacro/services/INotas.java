package com.simulacro.services;

import com.simulacro.dto.NotasDto;
import com.simulacro.model.Notas;

public interface INotas {

    Notas guardar(NotasDto notas) throws Exception;

}


