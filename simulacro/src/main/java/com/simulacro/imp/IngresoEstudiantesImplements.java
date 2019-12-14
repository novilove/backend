package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.MailExisteException;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.map.MapaIngresoEstudiantes;
import com.simulacro.model.Estudiantes;
import com.simulacro.model.IngresoEstudiantes;
import com.simulacro.repository.EstudianteRepository;
import com.simulacro.repository.IngresoEstudianteRepository;
import com.simulacro.services.IIngresoEstudianteService;
import com.simulacro.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoEstudiantesImplements implements IIngresoEstudianteService{
    @Autowired
    private IngresoEstudianteRepository ingresoEstudianteRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MapaIngresoEstudiantes mapa;

    @Override
    public IngresoEstudiantes guardarEstudiante(ReqDtoCrearUsuario estudianteDto) throws Exception {
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
                return ingresoEstudiante;
            }
            if(validarMail != null && validarRut == null){
                throw  new MailExisteException(Constant.ERROR_MAIL_EXISTE);
            }
            else{
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }

    @Override
    public IngresoEstudiantes buscarId(Long id)  {
        IngresoEstudiantes estudianteLocal = null;
        try{
            estudianteLocal = mapa.trasformarOpcionalIngresoEstudiantes(ingresoEstudianteRepository.findById(id));
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
