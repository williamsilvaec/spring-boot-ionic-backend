package com.williamsilva.cursomc.cursomc.services.exception;

public class ObjetoNotFoundException extends RuntimeException {

    public ObjetoNotFoundException(String message) {
        super(message);
    }

    public ObjetoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
