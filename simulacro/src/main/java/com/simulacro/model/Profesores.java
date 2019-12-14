package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="PROFESORES")
public class Profesores {

    @Id
    @Column(name="ID_PROFESOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOMBRE_PROFE", nullable = false)
    private String nombre;

    @Column(name="APELLIDO_PROFE", nullable = false)
    private String apellido;

    @Column(name="RUT_PROFE", unique = true, nullable = false)
    private String rut;

    @OneToOne
    @JoinColumn(name = "FK_INGRESO_PROFESOR", nullable = false)
    private IngresoProfesores ingresoProfesores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public IngresoProfesores getIngresoProfesores() {
        return ingresoProfesores;
    }

    public void setIngresoProfesores(IngresoProfesores ingresoProfesores) {
        this.ingresoProfesores = ingresoProfesores;
    }
}
