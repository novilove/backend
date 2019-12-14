package com.simulacro.exception;

public class UsuarioExistenteException extends Exception {
    private String message;

    //que deberiia hacer aca //correcto entonces ahora esto lo utilizaremos
    public UsuarioExistenteException(String message){
        super(message);
    }
}
