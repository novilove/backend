package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="ESTUDIANTES")
public class Estudiantes {
    @Id
    @Column(name="ID_EST")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEst;
    @Column(name="NOMBRE_EST", nullable = false)
    private String nombreEst;
    @Column(name="APELLIDO_EST", nullable = false)
    private String apellidoEst;
    @Column(name="RUT_EST", unique = true,nullable = false)
    private String rut;
    @Column(name="CORREO_EST", unique = true, nullable = false)
    private String correo;
    @Column(name="CONTRASENA_EST", nullable = false )
    private String contrasena;

    public Long getIdEst() {
        return idEst;
    }

    public void setIdEst(Long idEst) {
        this.idEst = idEst;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getApellidoEst() {
        return apellidoEst;
    }

    public void setApellidoEst(String apellidoEst) {
        this.apellidoEst = apellidoEst;
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

    public Estudiantes(Long idEst, String nombreEst, String apellidoEst, String rut, String correo, String contrasena) {
        this.idEst = idEst;
        this.nombreEst = nombreEst;
        this.apellidoEst = apellidoEst;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;

    }
}
