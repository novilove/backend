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
    private Long idMateria;

    @Column(name="NOMBRE_M", nullable = false)
    private String nombreM;

    @OneToOne
    @JoinColumn(name = "FK_ID_PROFESOR", nullable = false)
    private Profesores profesores;

    @OneToOne(mappedBy = "idMateria",cascade = CascadeType.ALL)
    private MateriaCurso ambas;

    @OneToOne(mappedBy = "materia",cascade = CascadeType.ALL)
    private Notas nota;

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

    public MateriaCurso getAmbas() {
        return ambas;
    }

    public void setAmbas(MateriaCurso ambas) {
        this.ambas = ambas;
    }

    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }
}
