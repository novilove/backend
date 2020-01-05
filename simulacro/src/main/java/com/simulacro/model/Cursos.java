package com.simulacro.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CURSOS")
public class Cursos {

    @Id
    @Column(name ="ID_CURSO")
    private Long idCurso;

    @Column(name="NOMBRE_CURSO")
    private String nombre;

    @OneToMany(mappedBy = "idCurso",cascade = CascadeType.ALL)
    private List<MateriaCurso> cursos;

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

    public List<MateriaCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<MateriaCurso> cursos) {
        this.cursos = cursos;
    }
}
