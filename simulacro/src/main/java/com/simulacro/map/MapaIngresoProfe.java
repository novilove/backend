package com.simulacro.map;

import com.simulacro.model.IngresoProfesores;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapaIngresoProfe {

    public IngresoProfesores trasformarOpcionalIngresoProfesores(Optional<IngresoProfesores> ingresoOpcional){

        IngresoProfesores ingreso =null;
        try{
            if(ingresoOpcional.isPresent()){
                ingreso= new IngresoProfesores();
                ingreso.setId(ingresoOpcional.get().getId());
                ingreso.setContrasena(ingresoOpcional.get().getContrasena());
                ingreso.setCorreo(ingresoOpcional.get().getCorreo());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ingreso;
    }

}
