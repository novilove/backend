package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.model.IngresoProfesores;
import com.simulacro.model.Profesores;
import com.simulacro.repository.IngresoProfesorRepository;
import com.simulacro.repository.ProfesoRepository;
import com.simulacro.services.IIngresoProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoProfesorImplements implements IIngresoProfesorService {
    @Autowired
    private ProfesoRepository profeRepository;

    @Autowired
    private IngresoProfesorRepository ingresoRespository;

    @Override
    public IngresoProfesores guardarProfesor(ReqDtoCrearProfe profesorDto) {
        IngresoProfesores profesorLocal = null;
        Profesores profesores = null;
        try{
            IngresoProfesores validarMail = ingresoRespository.findByCorreoProfe(profesorDto.getEmailDto());
            Profesores validarRut = profeRepository.findByRutProfe(profesorDto.getRutDto());
            if(validarMail == null && validarRut == null) {
                profesorLocal = new IngresoProfesores();
                profesorLocal.setCorreo(profesorDto.getEmailDto());
                profesorLocal.setContrasena(profesorDto.getPasswordDto());
                profesorLocal = ingresoRespository.save(profesorLocal);


                profesores = new Profesores();
                profesores.setNombre(profesorDto.getNombreDto());
                profesores.setApellido(profesorDto.getApellidoDto());
                profesores.setRut(profesorDto.getRutDto());
                profesores.setIngresoProfesores(profesorLocal);
                profesores = profeRepository.save(profesores);

                profesorLocal.setProfesores(profesores);
            }
            else {
                ingresoRespository.deleteById(profesorLocal.getId());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profesorLocal;
    }

    @Override
    public IngresoProfesores busrcarId(Long id) {
        IngresoProfesores profeLocal = null;
        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profeLocal;

    }

}
