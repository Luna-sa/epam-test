package com.lunasa.flowerstore.models;

public class Bouquet {

    protected String flowerId;
    protected String name;
    protected String type;
    protected String description;
    protected int flowerCount;
    protected int pricePerFlowerUah;
    protected String imageUrl;

    public Bouquet(String flowerId, String name, String type, String description, int flowerCount, int pricePerFlowerUah, String imageUrl) {
        this.flowerId = flowerId;
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

    public String getFlowerId() {
        return flowerId;
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
