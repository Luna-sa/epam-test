package com.lunasa.flowerstore.models;

import com.lunasa.flowerstore.exceptions.UnknownBouquetException;

public class BouquetData {

    // General bouquet
    private String flowerId;
    private String name;
    private String type;
    private String description;
    private int flowerCount;
    private int pricePerFlowerUah;
    private String imageUrl;
    // Lily bouquet
    private int closedFlowerCount;
    // Rose bouquet
    private String roseLength;

    public Bouquet convertToBouquet() {
        switch (type) {
            case "rose":
                return new RoseBouquet(flowerId, name, description, flowerCount, pricePerFlowerUah, roseLength, imageUrl);
            case "lily":
                return new LilyBouquet(flowerId, name, description, flowerCount, pricePerFlowerUah, closedFlowerCount, imageUrl);
            case "tulip":
            case "iris":
                return new Bouquet(flowerId, name, type, description, flowerCount, pricePerFlowerUah, imageUrl);
            default: throw new UnknownBouquetException(type);
        }
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFlowerCount() {
        return flowerCount;
    }

    public void setFlowerCount(int flowerCount) {
        this.flowerCount = flowerCount;
    }

    public int getPricePerFlowerUah() {
        return pricePerFlowerUah;
    }

    public void setPricePerFlowerUah(int pricePerFlowerUah) {
        this.pricePerFlowerUah = pricePerFlowerUah;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getClosedFlowerCount() {
        return closedFlowerCount;
    }

    public void setClosedFlowerCount(int closedFlowerCount) {
        this.closedFlowerCount = closedFlowerCount;
    }

    public String getRoseLength() {
        return roseLength;
    }

    public void setRoseLength(String roseLength) {
        this.roseLength = roseLength;
    }
}
