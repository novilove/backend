package com.simulacro.repository;

import com.simulacro.model.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiantes,Long> {
}
