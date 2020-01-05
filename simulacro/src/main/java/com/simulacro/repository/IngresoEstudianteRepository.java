package com.simulacro.repository;

import com.simulacro.model.IngresoEstudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoEstudianteRepository extends JpaRepository<IngresoEstudiantes, Long> {

    IngresoEstudiantes findByCorreo(String email);
}
