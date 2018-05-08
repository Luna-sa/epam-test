package com.lunasa.flowerstore.models;

public class BouquetSupply {

    private Bouquet bouquet;
    private int count;

    public BouquetSupply(Bouquet bouquet, int count) {
        this.count = count;
        this.bouquet = bouquet;
    }

    public int getCount() {
        return count;
    }

    public Bouquet getBouquet() {
        return bouquet;
    }
}
