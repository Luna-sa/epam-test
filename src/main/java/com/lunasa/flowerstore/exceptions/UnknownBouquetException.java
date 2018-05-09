package com.lunasa.flowerstore.exceptions;

public class UnknownBouquetException extends RuntimeException {

    public UnknownBouquetException(String bouquetId) {
        super("Cannot find bouquet with ID " + bouquetId);
    }
}
