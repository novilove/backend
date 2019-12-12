package com.simulacro.model;

import javax.persistence.*;

//anotacion de persistencia de jpa, declara que es una entidad
@Entity
@Table(name ="Login")//nombre de la tabla

public class Login {

    @Id
    @Column(name="id_login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="correo", unique = true, nullable = false)
    private String correo;
    @Column(name= "contraseña", nullable = false)
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
