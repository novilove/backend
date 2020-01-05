package com.simulacro.exception;

public class UsuarioExistenteException extends Exception {
    private String message;

    public UsuarioExistenteException(String message){
        super(message);
    }

}