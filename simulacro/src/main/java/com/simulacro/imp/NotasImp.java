package com.simulacro.imp;

import com.simulacro.dto.NotasDto;
import com.simulacro.exception.NoEncontradoException;
import com.simulacro.model.Notas;
import com.simulacro.repository.NotasRepository;
import com.simulacro.services.INotas;
import com.simulacro.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasImp implements INotas {
    @Autowired
    private NotasRepository notasRepository;

    @Override
    public Notas guardar(NotasDto guardar) throws Exception {
        Notas notasl = null;
        //notasl =notasRepository.findAll(notas);
        try {
            if (guardar.getDonde().equals("parcial")) {
                if (guardar.getPosicion() == 1) {
                    notasl.setNotap1(guardar.getNota());
                }
                if (guardar.getPosicion() == 2) {
                    notasl.setNotap2(guardar.getNota());
                }
                if (guardar.getPosicion() == 3) {
                    notasl.setNotap3(guardar.getNota());
                }
                if (guardar.getPosicion() == 4) {
                    notasl.setNotap4(guardar.getNota());
                }
            }
            if (guardar.getDonde().equals("control")) {
                if (guardar.getPosicion() == 1) {
                    notasl.setNotac1(guardar.getNota());
                }
                if (guardar.getPosicion() == 2) {
                    notasl.setNotac2(guardar.getNota());
                }
                if (guardar.getPosicion() == 3) {
                    notasl.setNotac3(guardar.getNota());
                }
                if (guardar.getPosicion() == 4) {
                    notasl.setNotac4(guardar.getNota());
                }
            }
            if (guardar.getDonde() == null) {
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return notasl;

    }
}