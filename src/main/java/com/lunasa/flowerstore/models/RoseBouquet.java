package com.lunasa.flowerstore.models;

public class RoseBouquet extends Bouquet {

    protected String roseLength;

    public RoseBouquet(String bouquetId, String name, String description, int flowerCount, int pricePerFlowerUah, String roseLength, String imageUrl) {
        super(bouquetId, name, "rose", description, flowerCount, pricePerFlowerUah, imageUrl);

        this.roseLength = roseLength;
    }

    public String getRoseLength() {
        return roseLength;
    }

    @Override
    public int calculatePriceUah() {
        if (roseLength.equals("long")) {
            return (int)Math.round(flowerCount * pricePerFlowerUah * 1.5);
        } else {
            return flowerCount * pricePerFlowerUah;
        }
    }
}
