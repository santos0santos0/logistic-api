package com.santos0santos0.log.domain.exception;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 861948453260607031L;

    public DomainException(String message) {
        super(message);
    }

}
