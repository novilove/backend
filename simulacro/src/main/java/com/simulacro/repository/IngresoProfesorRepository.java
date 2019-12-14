package com.simulacro.repository;

import com.simulacro.model.IngresoProfesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoProfesorRepository extends JpaRepository<IngresoProfesores, Long> {

    IngresoProfesores findByCorreo(String correo);
}
