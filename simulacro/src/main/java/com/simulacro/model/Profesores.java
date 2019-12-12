package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="PROFESORES")
public class Profesores {

    @Id
    @Column(name="ID_PROFESOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfe;

    @Column(name="NOMBRE_PROFE", nullable = false)
    private String nombreProfe;
    @Column(name="APELLIDO_PROFE", nullable = false)
    private String apellidoProfe;
    @Column(name="RUT_PROFE", unique = true, nullable = false)
    private String rut;
    @Column(name="CORREO_PROFE", unique = true, nullable = false)
    private String correo;
    @Column(name="CONTRASENA_PROFE", nullable = false)
    private String contrasena;

    public Profesores(Long idProfe, String nombreProfe, String apellidoProfe, String rut, String correo, String contrasena) {
        this.idProfe = idProfe;
        this.nombreProfe = nombreProfe;
        this.apellidoProfe = apellidoProfe;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Long getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(Long idProfe) {
        this.idProfe = idProfe;
    }

    public String getNombreProfe() {
        return nombreProfe;
    }

    public void setNombreProfe(String nombreProfe) {
        this.nombreProfe = nombreProfe;
    }

    public String getApellidoProfe() {
        return apellidoProfe;
    }

    public void setApellidoProfe(String apellidoProfe) {
        this.apellidoProfe = apellidoProfe;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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
