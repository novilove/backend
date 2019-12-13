package com.simulacro.imp;

import com.simulacro.model.Ingreso_Estudiantes;
import com.simulacro.repository.IngresoEstudianteRepository;
import com.simulacro.services.IIngresoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.EmptyStackException;

public class IngresoEstudiantesImplements implements IIngresoEstudianteService{
    @Autowired
    private IngresoEstudianteRepository ingresoEstudianteRepository;

    @Override
    public Ingreso_Estudiantes guardarEstudiante(Ingreso_Estudiantes estudiante) {
        Ingreso_Estudiantes estudianteLocal = null;
        try{
            estudianteLocal = ingresoEstudianteRepository.save(estudiante);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return estudianteLocal;
    }

    @Override
    public Ingreso_Estudiantes buscarId(Long id) {
        Ingreso_Estudiantes estudianteLocal = null;
        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return estudianteLocal;
    }


}
