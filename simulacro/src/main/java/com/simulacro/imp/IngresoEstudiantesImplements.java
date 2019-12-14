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
            IngresoEstudiantes validarMail = ingresoEstudianteRepository.findByCorreo(estudianteDto.getEmailDto());
            Estudiantes validarRut = estudianteRepository.findByRut(estudianteDto.getRutDto());
            if(validarMail == null && validarRut == null) {
                //crear login y estudiante
                ingresoEstudiante = new IngresoEstudiantes();
                ingresoEstudiante.setCorreo(estudianteDto.getEmailDto());
                ingresoEstudiante.setContrasena(estudianteDto.getPasswordDto());
                ingresoEstudiante = ingresoEstudianteRepository.save(ingresoEstudiante);

                estudiantes = new Estudiantes();
                estudiantes.setApellido(estudianteDto.getApellidoDto());
                estudiantes.setNombre(estudianteDto.getNombreDto());
                estudiantes.setRut(estudianteDto.getRutDto());
                estudiantes.setIngresoEstudiantes(ingresoEstudiante);
                estudiantes = estudianteRepository.save(estudiantes);

                ingresoEstudiante.setEstudiantes(estudiantes);

            }
            else{
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




    @Override
    public boolean eliminarEstudiante(Long id) {
        return false;
    }


}
