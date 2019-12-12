package com.simulacro.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

//anotacion de persistencia de jpa, declara que es una entidad
@Entity
@Table(name ="INGRESO_ESTUDIANTES")//nombre de la tabla

public class Ingreso_Estudiantes {

    @Id
    @Column(name="ID_INGRESO_ESTUDIANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CORREO", unique = true, nullable = false)
    @Email
    private String correo;
    @Column(name= "CONTRASEÑA", nullable = false)
    private String contrasena;

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
}
