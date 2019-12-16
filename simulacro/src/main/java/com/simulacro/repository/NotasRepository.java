package com.simulacro.repository;


import com.simulacro.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends JpaRepository< Notas, Long> {
    Notas findByMateriaAndEstudiante(Long idMateria,Long idEstudiante);
}
