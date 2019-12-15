package com.simulacro.imp;

import com.simulacro.model.Notas;
import com.simulacro.repository.NotasRepository;
import com.simulacro.services.INotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class NotasImp implements INotas {
    @Autowired
    private NotasRepository notasRepository;
    @Override
    public Notas VerNotas(Notas notas) {
        Notas notasl = null;
        //notasl =notasRepository.findAll(notas);
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return notasl;

    }
}