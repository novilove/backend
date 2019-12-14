package com.simulacro.map;

import com.simulacro.model.IngresoEstudiantes;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapaIngresoEstudiantes {
    public IngresoEstudiantes trasformarOpcionalIngresoEstudiantes(Optional<IngresoEstudiantes> ingresoOpcional){
        IngresoEstudiantes ingreso =null;
        try{
            if(ingresoOpcional.isPresent()){
                ingreso= new IngresoEstudiantes();
                ingreso.setIdIngresoEstudiantes(ingresoOpcional.get().getIdIngresoEstudiantes());
                ingreso.setContrasena(ingresoOpcional.get().getContrasena());
                ingreso.setCorreo(ingresoOpcional.get().getCorreo());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ingreso;
    }


}
