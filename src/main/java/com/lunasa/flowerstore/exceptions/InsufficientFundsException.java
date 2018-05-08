package com.lunasa.flowerstore.exceptions;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String userId) {
        super("Insufficient funds for user " + userId);
    }
}
