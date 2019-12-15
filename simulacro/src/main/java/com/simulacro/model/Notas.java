package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="NOTAS")
public class Notas {

    @Id
    @Column(name = "ID_NOTAS")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="FK_ID_ESTUDIANTES", nullable = false )
    private Estudiantes estudiante;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MATERIAS", nullable = false)
    private Materias materia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }
}
