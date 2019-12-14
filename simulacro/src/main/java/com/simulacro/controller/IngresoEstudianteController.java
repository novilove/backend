package com.simulacro.controller;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.imp.IngresoEstudiantesImplements;
import com.simulacro.model.IngresoEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingreso")
public class IngresoEstudianteController {

    @Autowired
    private IngresoEstudiantesImplements estudianteImp;

    @RequestMapping(method = RequestMethod.POST)
    public IngresoEstudiantes guardarEstudiante(@RequestBody ReqDtoCrearUsuario ReqDtoCrearUsuario){

        IngresoEstudiantes estudianteController = null;

        try{
            estudianteController = estudianteImp.guardarEstudiante(ReqDtoCrearUsuario);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return estudianteController;
    }


}
