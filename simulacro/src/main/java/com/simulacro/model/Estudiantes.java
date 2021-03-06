package com.simulacro.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ESTUDIANTES")
public class Estudiantes {


    @Id
    @Column(name="ID_EST")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name="NOMBRE_EST", nullable = false)
    private String nombre;
  
    @Column(name="APELLIDO_EST", nullable = false)
    private String apellido;
  
    @Column(name="RUT_EST", unique = true,nullable = false)
    private String rut;

    @OneToOne
    @JoinColumn(name = "FK_INGRESO_ESTUDIANTE", nullable = false)
    private IngresoEstudiantes ingresoEstudiantes;

    @OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
    private List<Notas> notas;

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

    public IngresoEstudiantes getIngresoEstudiantes() {
        return ingresoEstudiantes;
    }

    public void setIngresoEstudiantes(IngresoEstudiantes ingresoEstudiantes) {
        this.ingresoEstudiantes = ingresoEstudiantes;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
}
