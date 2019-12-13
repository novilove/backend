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

    @OneToOne
    @JoinColumn(name = "FK_INGRESO_ESTUDIANTE", nullable = false)
    private IngresoEstudiantes ingresoEstudiantes;

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

    public IngresoEstudiantes getIngresoEstudiantes() {
        return ingresoEstudiantes;
    }

    public void setIngresoEstudiantes(IngresoEstudiantes ingresoEstudiantes) {
        this.ingresoEstudiantes = ingresoEstudiantes;
    }
}
