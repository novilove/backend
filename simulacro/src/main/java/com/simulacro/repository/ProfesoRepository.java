package com.simulacro.repository;

import com.simulacro.model.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesoRepository extends JpaRepository<Profesores, Long> {
    Profesores findByRutProfe(String rut);
}
