package com.simulacro.controller;

import com.simulacro.dto.ReqDtoCrearProfe;
import com.simulacro.exception.UsuarioExistenteException;
import com.simulacro.imp.IngresoProfesorImplements;
import com.simulacro.model.IngresoProfesores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingresoprofe")
public class IngresoProfesorController {

    @Autowired
    private IngresoProfesorImplements profesorImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> guardarProfesor(@RequestBody ReqDtoCrearProfe reqDtoCrearProfe){

       ResponseEntity<Object> rs = null;

       //ahora van a cambiar los estatus mira
        try{
            rs = new ResponseEntity<Object>(profesorImp.guardarProfesor(reqDtoCrearProfe), HttpStatus.OK);//eso se deberia responder, pero que cambia? el se
            // ultado a la base de datos? // nop la respuesta hacia afuera mira
        }catch (UsuarioExistenteException ex){
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
