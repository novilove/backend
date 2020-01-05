package com.simulacro.model;

import javax.persistence.*;
import java.util.List;

//traten de entender relaciones manyToOne OneToMany como se utiliza  sisisi las googleareee hay ejemplos como hacerlo,
//creo que eso es parte de ustedes buscar y entender para implementarlo ahora que el tiempo esta un poco a nuestro favor podre buscarlo
// ya bacan nos vvemos nos vemos byeee busquen ! de todas maneras
@Entity
@Table(name="MATERIAS")
public class Materias {
    @Id
    @Column(name="ID_MATERIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateria;

    @Column(name="NOMBRE_M", nullable = false)
    private String nombreM;

    @OneToOne
    @JoinColumn(name = "FK_ID_PROFESOR", nullable = false)
    private Profesores profesores;

    @OneToMany(mappedBy = "idMateria",cascade = CascadeType.ALL)
    private List<Materias> materias;

    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL)
    private List<Notas> notas;

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    public List<Materias> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materias> materias) {
        this.materias = materias;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
}
