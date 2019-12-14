package com.simulacro.model;

import javax.persistence.*;

//traten de entender relaciones manyToOne OneToMany como se utiliza  sisisi las googleareee hay ejemplos como hacerlo,
//creo que eso es parte de ustedes buscar y entender para implementarlo ahora que el tiempo esta un poco a nuestro favor podre buscarlo
// ya bacan nos vvemos nos vemos byeee busquen ! de todas maneras
@Entity
@Table(name="MATERIAS")
public class Materias {
    @Id
    @Column(name="ID_MATERIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materia;

    @Column(name="NOMBRE_M", nullable = false)
    private String nombreM;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_PROFESOR", referencedColumnName = "ID_PROFESOR")
    private Profesores profesores;

    public Materias(Long id_materia, String nombreM, Profesores profesores) {
        this.id_materia = id_materia;
        this.nombreM = nombreM;
        this.profesores = profesores;
    }

    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
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
}
