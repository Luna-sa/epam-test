package com.lunasa.flowerstore.models;

public class RoseBouquet extends Bouquet {

    protected String roseLength;

    public RoseBouquet(String flowerId, String name, String description, int flowerCount, int pricePerFlowerUah, String roseLength, String imageUrl) {
        super(flowerId, name, "rose", description, flowerCount, pricePerFlowerUah, imageUrl);

        this.roseLength = roseLength;
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
