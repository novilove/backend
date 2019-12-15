package com.simulacro.controller;

import com.simulacro.dto.ReqDtoCrearUsuario;
import com.simulacro.exception.MailExisteException;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.imp.IngresoEstudiantesImplements;
import com.simulacro.model.IngresoEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingreso")
public class IngresoEstudianteController {

    @Autowired
    private IngresoEstudiantesImplements estudianteImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> guardarEstudiante(@RequestBody ReqDtoCrearUsuario reqDtoCrearUsuario){
        ResponseEntity<Object> rs = null;

        try{
            rs = new ResponseEntity<Object>(estudianteImp.guardarEstudiante(reqDtoCrearUsuario), HttpStatus.OK);

        }catch (UsuarioExistenteException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (MailExisteException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> buscarId(@PathVariable Long id){
        ResponseEntity<Object> rs = null;

        try{
            rs = new ResponseEntity<Object>(estudianteImp.buscarId(id), HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarEstudiante(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(estudianteImp.eliminarEstudiante(id),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listarEstudiantes(){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(estudianteImp.listarEstudiantes(),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }

}
