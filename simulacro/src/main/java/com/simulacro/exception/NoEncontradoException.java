package com.simulacro.exception;


public class NoEncontradoException extends Exception{
    private String message;

    public NoEncontradoException(String message){
        super(message);
    }
}
