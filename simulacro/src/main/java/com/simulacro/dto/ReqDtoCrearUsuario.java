package com.simulacro.dto;


public class ReqDtoCrearUsuario {

    private String emailDto;
    private String passwordDto;
    private String nombreEstDto;
    private String apellidoEstDto;
    private String rutDto;

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    public String getNombreEstDto() {
        return nombreEstDto;
    }

    public void setNombreEstDto(String nombreEstDto) {
        this.nombreEstDto = nombreEstDto;
    }

    public String getApellidoEstDto() {
        return apellidoEstDto;
    }

    public void setApellidoEstDto(String apellidoEstDto) {
        this.apellidoEstDto = apellidoEstDto;
    }

    public String getRutDto() {
        return rutDto;
    }

    public void setRutDto(String rutDto) {
        this.rutDto = rutDto;
    }
}
