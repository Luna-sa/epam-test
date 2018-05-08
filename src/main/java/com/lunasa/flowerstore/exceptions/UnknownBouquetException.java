package com.lunasa.flowerstore.exceptions;

public class UnknownBouquetException extends RuntimeException {

    public UnknownBouquetException(String type) {
        super("Unknown bouquet with type " + type);
    }
}
