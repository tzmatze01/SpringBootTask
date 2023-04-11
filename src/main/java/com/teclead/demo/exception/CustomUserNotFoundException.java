package com.teclead.demo.exception;

public class CustomUserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomUserNotFoundException(String message) {
        super(message);
    }
}
