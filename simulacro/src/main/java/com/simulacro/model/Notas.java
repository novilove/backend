package com.simulacro.model;

import javax.persistence.*;

@Entity
@Table(name="Notas")
public class Notas {

    @Id
    @Column(name="")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "", nullable = false)
    private float notap1;
    @Column(name= "", nullable = false)
    private float notap2;
    @Column(name= "", nullable = false)
    private float notap3;
    @Column(name= "", nullable = false)
    private float notap4;
    @Column(name= "", nullable = false)

    private float notac1;
    @Column(name= "", nullable = false)
    private float notac2;
    @Column(name= "", nullable = false)
    private float notac3;
    @Column(name= "", nullable = false)
    private float notac4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getNotap1() {
        return notap1;
    }

    public void setNotap1(float notap1) {
        this.notap1 = notap1;
    }

    public float getNotap2() {
        return notap2;
    }

    public void setNotap2(float notap2) {
        this.notap2 = notap2;
    }

    public float getNotap3() {
        return notap3;
    }

    public void setNotap3(float notap3) {
        this.notap3 = notap3;
    }

    public float getNotap4() {
        return notap4;
    }

    public void setNotap4(float notap4) {
        this.notap4 = notap4;
    }

    public float getNotac1() {
        return notac1;
    }

    public void setNotac1(float notac1) {
        this.notac1 = notac1;
    }

    public float getNotac2() {
        return notac2;
    }

    public void setNotac2(float notac2) {
        this.notac2 = notac2;
    }

    public float getNotac3() {
        return notac3;
    }

    public void setNotac3(float notac3) {
        this.notac3 = notac3;
    }

    public float getNotac4() {
        return notac4;
    }

    public void setNotac4(float notac4) {
        this.notac4 = notac4;
    }
}
