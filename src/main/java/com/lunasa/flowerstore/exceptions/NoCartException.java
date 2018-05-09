package com.lunasa.flowerstore.exceptions;

public class NoCartException extends RuntimeException {

    public NoCartException(String userId) {
        super("The cart does not exist for user " + userId);
    }
}
