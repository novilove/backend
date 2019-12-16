package com.simulacro.controller;

import com.simulacro.dto.NotasDto;
import com.simulacro.exception.NoEncontradoException;

import com.simulacro.imp.NotasImp;
import com.simulacro.model.Notas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notas")

public class NotasController {
    @Autowired
    private NotasImp notasImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> guardar(@RequestBody NotasDto notas) throws Exception {
        ResponseEntity<Object> rs = null;
        Notas notasController = null;
        try {
            rs = new ResponseEntity<Object>(notasImp.guardar(notas), HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
