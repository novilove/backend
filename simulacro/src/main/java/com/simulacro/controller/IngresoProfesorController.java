package com.simulacro.controller;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.imp.IngresoProfesorImplements;
import com.simulacro.model.IngresoProfesores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingresoprofe")
public class IngresoProfesorController {

    @Autowired
    private IngresoProfesorImplements profesorImp;

    @RequestMapping(method = RequestMethod.POST)
    public IngresoProfesores guardarProfesor(@RequestBody ReqDtoCrearProfe reqDtoCrearProfe){

        IngresoProfesores profesorController = null;

        try{
            profesorController = profesorImp.guardarProfesor(reqDtoCrearProfe);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return profesorController;
    }

}
