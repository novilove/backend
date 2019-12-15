package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name = "MATERIA_CURSO")
public class MateriaCurso {

    @Id
    @Column(name = "ID_MATERIA_CURSO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_ID_CURSO", nullable = false)
    private Cursos idCurso;

    @OneToOne
    @JoinColumn(name = "FK_ID_MATERIA", nullable = false)
    private Materias idMateria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Cursos idCurso) {
        this.idCurso = idCurso;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }
}
