package com.devsuperior.bds02.exceptions;

public class IsNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IsNotFoundException(String message) {
        super(message);
    }
}
