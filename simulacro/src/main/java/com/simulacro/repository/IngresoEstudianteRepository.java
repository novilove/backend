package com.simulacro.repository;

import com.simulacro.model.Ingreso_Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoEstudianteRepository extends JpaRepository<Ingreso_Estudiantes, Long> {

    Ingreso_Estudiantes findByEmail(String email);
}
