package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="CURSOS")
public class Cursos {

    @Id
    @Column(name ="ID_CURSO")
    private Long idCurso;

    @Column(name="NOMBRE_CURSO")
    private String nombre;

    @OneToOne(mappedBy = "idCurso",cascade = CascadeType.ALL)
    private MateriaCurso ambas;

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MateriaCurso getAmbas() {
        return ambas;
    }

    public void setAmbas(MateriaCurso ambas) {
        this.ambas = ambas;
    }
}
