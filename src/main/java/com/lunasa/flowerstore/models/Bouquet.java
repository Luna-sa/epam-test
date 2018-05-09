package com.lunasa.flowerstore.models;

public class Bouquet {

    protected String bouquetId;
    protected String name;
    protected String type;
    protected String description;
    protected int flowerCount;
    protected int pricePerFlowerUah;
    protected String imageUrl;

    public Bouquet(String bouquetId, String name, String type, String description, int flowerCount, int pricePerFlowerUah, String imageUrl) {
        this.bouquetId = bouquetId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.flowerCount = flowerCount;
        this.pricePerFlowerUah = pricePerFlowerUah;
        this.imageUrl = imageUrl;
    }

    public int calculatePriceUah() {
        return flowerCount * pricePerFlowerUah;
    }

    public String getBouquetId() {
        return bouquetId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
