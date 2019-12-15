package com.simulacro.controller;

import com.simulacro.imp.NotasImp;
import com.simulacro.model.Notas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notas")

public class NotasController {
    @Autowired
    private NotasImp notasImp;

    @RequestMapping(method = RequestMethod.GET)
    public Notas verNotas(@RequestParam Notas notas){
        Notas notasController = null;
        try{
            notasController = notasImp.VerNotas(notas);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return notasController;
    }

}
