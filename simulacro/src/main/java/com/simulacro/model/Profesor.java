package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="PROFESOR")
public class Profesor {
    @Id
    @Column(name="ID_PROFESOR" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    @Column(name="NOMBRE_PROF", nullable = false)
    private String nombreProf;
    @Column(name="APELLIDO_PROF", nullable = false)
    private String apellidoProf;
    @Column(name="RUT", unique = true ,nullable = false)
    private String rut;
    @Column(name="CORREO", unique = true, nullable = false)
    private String correo;

    public Profesor(Long idProfesor, String nombreProf, String apellidoProf, String rut, String correo) {
        this.idProfesor = idProfesor;
        this.nombreProf = nombreProf;
        this.apellidoProf = apellidoProf;
        this.rut = rut;
        this.correo = correo;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public String getApellidoProf() {
        return apellidoProf;
    }

    public void setApellidoProf(String apellidoProf) {
        this.apellidoProf = apellidoProf;
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
}
