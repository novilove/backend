package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.MailExisteException;
import com.simulacro.exception.NoEncontradoException;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoEstudiantesImplements implements IIngresoEstudianteService{
    @Autowired
    private IngresoEstudianteRepository ingresoEstudianteRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MapaIngresoEstudiantes mapa;

    @Override
    public IngresoEstudiantes guardarIngresoEstudiante(ReqDtoCrearUsuario estudianteDto) throws Exception {
        IngresoEstudiantes ingresoEstudiante = null;
        Estudiantes estudiantes = null;
        try {
            IngresoEstudiantes validarMail = ingresoEstudianteRepository.findByCorreo(estudianteDto.getEmailDto());
            Estudiantes validarRut = estudianteRepository.findByRut(estudianteDto.getRutDto());
            if (validarMail == null && validarRut == null) {
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
            if (validarMail != null && validarRut == null) {
                throw new MailExisteException(Constant.ERROR_MAIL_EXISTE);
            } else {
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }
        }catch (MailExisteException ex) {
            ex.printStackTrace();
            throw new MailExisteException(ex.getMessage());
        }catch (UsuarioExistenteException ex){
            ex.printStackTrace();
            throw new UsuarioExistenteException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }




    @Override
    public IngresoEstudiantes buscarId(Long id) throws Exception {
        IngresoEstudiantes estudianteLocal = null;
        try {
            estudianteLocal = mapa.trasformarOpcionalIngresoEstudiantes(ingresoEstudianteRepository.findById(id));
            if(null == estudianteLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return estudianteLocal;
    }




    @Override
    public boolean eliminarIngresoEstudiante(Long id) throws Exception{
        try{

            IngresoEstudiantes estudianteLocal = mapa.trasformarOpcionalIngresoEstudiantes(ingresoEstudianteRepository.findById(id));//metodo que se encarga de transformar el objeto que retorna crud repository
            if(null == estudianteLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                ingresoEstudianteRepository.deleteById(id);
                return true;
            }
        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }
    }

    @Override
    public List<IngresoEstudiantes> listarIngresoEstudiantes() throws Exception {

        List<IngresoEstudiantes> listIngreso = new ArrayList<>();
        try {
            listIngreso = ingresoEstudianteRepository.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listIngreso;
    }


}
