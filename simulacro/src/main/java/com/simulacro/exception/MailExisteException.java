package com.simulacro.exception;

public class MailExisteException extends Exception {
    private String message;

    public MailExisteException(String message){
        super(message);
    }

}
