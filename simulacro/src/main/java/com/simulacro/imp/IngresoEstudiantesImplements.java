package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.model.Estudiantes;
import com.simulacro.model.IngresoEstudiantes;
import com.simulacro.repository.EstudianteRepository;
import com.simulacro.repository.IngresoEstudianteRepository;
import com.simulacro.services.IIngresoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoEstudiantesImplements implements IIngresoEstudianteService{
    @Autowired
    private IngresoEstudianteRepository ingresoEstudianteRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public IngresoEstudiantes guardarEstudiante(ReqDtoCrearUsuario estudianteDto) {
        IngresoEstudiantes ingresoEstudiante = null;
        Estudiantes estudiantes = null;
        try{
            ingresoEstudiante = new IngresoEstudiantes();
            ingresoEstudiante.setCorreo(estudianteDto.getEmailDto());
            ingresoEstudiante.setContrasena(estudianteDto.getPasswordDto());

            ingresoEstudiante = ingresoEstudianteRepository.save(ingresoEstudiante);

            if(null != ingresoEstudiante){
                estudiantes = new Estudiantes();
                estudiantes.setApellidoEst(estudianteDto.getApellidoEstDto());
                estudiantes.setNombreEst(estudianteDto.getNombreEstDto());
                estudiantes.setRut(estudianteDto.getRutDto());
                estudiantes.setIngresoEstudiantes(ingresoEstudiante);
                estudiantes = estudianteRepository.save(estudiantes);
            }else{
                ingresoEstudianteRepository.deleteById(ingresoEstudiante.getIdIngresoEstudiantes());
            }



        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ingresoEstudiante;
    }

    @Override
    public IngresoEstudiantes buscarId(Long id) {
        IngresoEstudiantes estudianteLocal = null;
        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return estudianteLocal;
    }


}
