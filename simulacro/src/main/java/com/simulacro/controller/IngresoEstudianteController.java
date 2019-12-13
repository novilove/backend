package com.simulacro.controller;

import com.simulacro.imp.IngresoEstudiantesImplements;

import com.simulacro.model.Ingreso_Estudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingreso")
public class IngresoEstudianteController {

    @Autowired
    private IngresoEstudiantesImplements estudianteImp;

    @RequestMapping(method = RequestMethod.POST)
    public Ingreso_Estudiantes guardarEstudiante(@RequestBody Ingreso_Estudiantes estudiante){

        Ingreso_Estudiantes estudianteController = null;

        try{
            estudianteController = estudianteImp.guardarEstudiante(estudiante);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return estudianteController;
    }


}
