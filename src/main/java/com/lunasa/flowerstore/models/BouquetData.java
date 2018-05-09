package com.lunasa.flowerstore.models;

import com.lunasa.flowerstore.exceptions.UnknownBouquetException;
import com.lunasa.flowerstore.exceptions.UnknownBouquetTypeException;

public class BouquetData {

    // General bouquet
    private String bouquetId;
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

    public static BouquetData convertFromBouquet(Bouquet bouquet) {
        BouquetData b = new BouquetData();
        b.setBouquetId(bouquet.getBouquetId());
        b.setName(bouquet.getName());
        b.setType(bouquet.getType());
        b.setDescription(bouquet.getDescription());
        b.setFlowerCount(bouquet.getFlowerCount());
        b.setPricePerFlowerUah(bouquet.getPricePerFlowerUah());
        b.setImageUrl(bouquet.getImageUrl());
        if (bouquet instanceof RoseBouquet) {
            RoseBouquet rb = (RoseBouquet)bouquet;
            b.setRoseLength(rb.getRoseLength());
        }
        if (bouquet instanceof LilyBouquet) {
            LilyBouquet lb = (LilyBouquet) bouquet;
            b.setClosedFlowerCount(lb.getClosedFlowerCount());
        }
        return b;
    }

    public Bouquet convertToBouquet() {
        switch (type) {
            case "rose":
                return new RoseBouquet(bouquetId, name, description, flowerCount, pricePerFlowerUah, roseLength, imageUrl);
            case "lily":
                return new LilyBouquet(bouquetId, name, description, flowerCount, pricePerFlowerUah, closedFlowerCount, imageUrl);
            case "tulip":
            case "iris":
                return new Bouquet(bouquetId, name, type, description, flowerCount, pricePerFlowerUah, imageUrl);
            default: throw new UnknownBouquetTypeException(type);
        }
    }

    public String getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(String bouquetId) {
        this.bouquetId = bouquetId;
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
