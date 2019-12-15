package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.map.MapaIngresoProfe;
import com.simulacro.model.IngresoEstudiantes;
import com.simulacro.model.IngresoProfesores;
import com.simulacro.model.Profesores;
import com.simulacro.repository.IngresoProfesorRepository;
import com.simulacro.repository.ProfesoRepository;
import com.simulacro.services.IIngresoProfesorService;
import com.simulacro.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoProfesorImplements implements IIngresoProfesorService {

    @Autowired
    private ProfesoRepository profeRepo;

    @Autowired
    private IngresoProfesorRepository ingresoRepo;

    @Autowired
    private MapaIngresoProfe mapa;

    @Override
    public IngresoProfesores guardarIngresoProfesor(ReqDtoCrearProfe profesorDto) throws Exception {
        try{
            IngresoProfesores validarMail = ingresoRepo.findByCorreo(profesorDto.getEmailDto());
            Profesores validarRut = profeRepo.findByRut(profesorDto.getRutDto());

            if(validarMail == null && validarRut == null) {
                IngresoProfesores ingresoNuevo = new IngresoProfesores();
                ingresoNuevo.setCorreo(profesorDto.getEmailDto());
                ingresoNuevo.setContrasena(profesorDto.getPasswordDto());
                ingresoNuevo = ingresoRepo.save(ingresoNuevo);

                Profesores profesorNuevo = new Profesores();
                profesorNuevo.setNombre(profesorDto.getNombreDto());
                profesorNuevo.setApellido(profesorDto.getApellidoDto());
                profesorNuevo.setRut(profesorDto.getRutDto());
                profesorNuevo.setIngresoProfesores(ingresoNuevo);
                profesorNuevo = profeRepo.save(profesorNuevo);

                profesorNuevo.setIngresoProfesores(ingresoNuevo);
                return ingresoNuevo;
            }else{
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }

        }catch(UsuarioExistenteException ex){
            throw new UsuarioExistenteException(ex.getMessage());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }

    @Override
    public IngresoProfesores busrcarId(Long id) throws Exception {
        IngresoProfesores profeLocal = null;
        try {
            profeLocal = mapa.trasformarOpcionalIngresoProfesores(ingresoRepo.findById(id));
            if(null == profeLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profeLocal;

    }

    @Override
    public boolean eliminarIngresoProfesor(Long id) throws Exception {
        boolean eliminado = false;
        try{

            IngresoProfesores profeLocal = mapa.trasformarOpcionalIngresoProfesores(ingresoRepo.findById(id));//metodo que se encarga de transformar el objeto que retorna crud repository
            if(null == profeLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                ingresoRepo.deleteById(id);
                return eliminado=true;
            }
        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return eliminado;
    }

    @Override
    public List<IngresoProfesores> listarIngresoProfesor() throws Exception {
        List<IngresoProfesores> listIngreso = new ArrayList<>();
        try {
            listIngreso = ingresoRepo.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listIngreso;
    }

}
