package com.simulacro.model;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;

@Entity
@Table(name="Estudiante")
public class Estudiantes {
    @Id

    private Long id;
}
