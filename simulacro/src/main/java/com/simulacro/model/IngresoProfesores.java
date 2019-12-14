package com.simulacro.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="INGRESO_PROFESORES")
public class IngresoProfesores {

    @Id
    @Column(name="ID_INGRESO_PROFESOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CORREO", unique = true, nullable = false)
    @Email
    private String correo;

    @Column(name= "CONTRASENA", nullable = false)
    private String contrasena;

    @OneToOne(mappedBy = "ingresoProfesores",cascade = CascadeType.ALL)
    private Profesores profesores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }
}
