package com.simulacro.repository;

import com.simulacro.model.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiantes,Long> {
    Estudiantes findByRut(String rut);
}
