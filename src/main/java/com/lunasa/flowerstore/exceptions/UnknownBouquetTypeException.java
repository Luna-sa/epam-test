package com.lunasa.flowerstore.exceptions;

public class UnknownBouquetTypeException extends RuntimeException {

    public UnknownBouquetTypeException(String type) {
        super("Cannot find bouquet with type " + type);
    }
}
