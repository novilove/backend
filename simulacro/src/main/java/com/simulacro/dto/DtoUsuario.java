package com.simulacro.dto;

public class DtoUsuario {

    private String emailDto;
    private String passwordDto;
    private String nombreDto;
    private String apellidoDto;
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

    public String getNombreDto() {
        return nombreDto;
    }

    public void setNombreDto(String nombreDto) {
        this.nombreDto = nombreDto;
    }

    public String getApellidoDto() {
        return apellidoDto;
    }

    public void setApellidoDto(String apellidoDto) {
        this.apellidoDto = apellidoDto;
    }

    public String getRutDto() {
        return rutDto;
    }

    public void setRutDto(String rutDto) {
        this.rutDto = rutDto;
    }
}
