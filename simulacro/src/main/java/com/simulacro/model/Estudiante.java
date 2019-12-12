package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="ESTUDIANTE")
public class Estudiante {
    @Id
    @Column(name="ID_ESTUDIANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @Column(name="NOMBRE_EST", nullable = false)
    private String nombreEst;
    @Column(name="APELLIDO_EST", nullable = false)
    private String apellidoEst;
    @Column(name="RUT", unique = true, nullable = false)
    private String rut;
    private String correo;
    private String contrasena;

}
