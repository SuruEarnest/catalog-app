package com.omnirio.catalog.app.exceptions;

public class PaymentRequiredException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PaymentRequiredException(String message) {
        super(message);
    }
}
