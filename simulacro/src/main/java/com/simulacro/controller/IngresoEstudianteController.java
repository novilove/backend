package com.simulacro.controller;

import com.simulacro.imp.IngresoEstudiantesImplements;

import com.simulacro.model.Ingreso_Estudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingreso_estudiantes")
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
