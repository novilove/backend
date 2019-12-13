package com.simulacro.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

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




}
