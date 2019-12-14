package com.simulacro.imp;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.model.IngresoProfesores;
import com.simulacro.model.Profesores;
import com.simulacro.repository.IngresoProfesorRepository;
import com.simulacro.repository.ProfesoRepository;
import com.simulacro.services.IIngresoProfesorService;
import com.simulacro.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoProfesorImplements implements IIngresoProfesorService {

    @Autowired
    private ProfesoRepository profeRepo;

    @Autowired
    private IngresoProfesorRepository ingresoRepo;

    @Override
    public IngresoProfesores guardarProfesor(ReqDtoCrearProfe profesorDto) throws Exception {
        try{
            IngresoProfesores validarMail = ingresoRepo.findByCorreo(profesorDto.getEmailDto());
            Profesores validarRut = profeRepo.findByRut(profesorDto.getRutDto());
            if(validarMail == null && validarRut == null) {
                IngresoProfesores ingresoNuevo = new IngresoProfesores();
                ingresoNuevo.setCorreo(profesorDto.getEmailDto());
                ingresoNuevo.setContrasena(profesorDto.getPasswordDto());
                ingresoNuevo = ingresoRepo.save(ingresoNuevo);

                //esto se le llama refactorizacion de codigo porque mejoramos algo que estaba antes ahora atraparemos los mensajes
                Profesores profesorNuevo = new Profesores();
                profesorNuevo.setNombre(profesorDto.getNombreDto());
                profesorNuevo.setApellido(profesorDto.getApellidoDto());
                profesorNuevo.setRut(profesorDto.getRutDto());
                profesorNuevo.setIngresoProfesores(ingresoNuevo);
                profesorNuevo = profeRepo.save(profesorNuevo);

                profesorNuevo.setIngresoProfesores(ingresoNuevo);
                return ingresoNuevo;
            }else{
                //esto es como deberia ser un buen backend jaja gracias lo pondre en practica... dale eso avanza y trata de implementar esto eso ayuda al front igual no?
                // el front puede tomarr ese mensaje y mostrarlo al usuario genial y incluso validar por codiigo http status no entio mucho de front es lo mismo
                // es solo codigo pero con distintas reglas sip no hay reglas ajjaja me gusto mas el backend
                //ya genial, dale entonces con lo que les falta traten de avazar solos y darse cuenta que pueden crear muchas cosas,
                //solo necesitan tener creatividad uuuffff tengo arta creatividad, vamos a ver que sale dale exito ! graciiaaaass
                // ya me dormire trata de probar las cosas y programar lo que les falta
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }

        }catch(UsuarioExistenteException ex){
            throw new UsuarioExistenteException(ex.getMessage());

        }catch (Exception ex){
            ex.printStackTrace();
            // en caso que se cayera por otro motivo enviamos ese mensaje viste ? siii
            //estos mensajes donde tienen que ir en una carpeta? util constant
            throw new Exception(Constant.ERROR_SISTEMA);
        }

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
