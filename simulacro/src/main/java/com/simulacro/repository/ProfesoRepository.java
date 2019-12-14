package com.simulacro.repository;

import com.simulacro.model.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesoRepository extends JpaRepository<Profesores, Long> {

    //aqui deberia estar el error -- existe un atributollo llamado RutProfe ? en Profesores solo rut, antes era rut profe pero pense que ese podia ser el error
    Profesores findByRut(String rut); //ese rut findByRut ese campo rut hace referencia a la entidad
}
