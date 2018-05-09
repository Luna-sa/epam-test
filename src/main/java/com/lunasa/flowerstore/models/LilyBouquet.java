package com.lunasa.flowerstore.models;

public class LilyBouquet extends Bouquet {

    protected int closedFlowerCount;

    public LilyBouquet(String bouquetId, String name, String description, int flowerCount, int pricePerFlowerUah, int closedFlowerCount, String imageUrl) {
        super(bouquetId, name, "lily", description, flowerCount, pricePerFlowerUah, imageUrl);

        this.closedFlowerCount = closedFlowerCount;
    }

    public int getClosedFlowerCount() {
        return closedFlowerCount;
    }

    @Override
    public int calculatePriceUah() {
        int openedFlowerCount = flowerCount - closedFlowerCount;
        return (int)Math.round(openedFlowerCount * pricePerFlowerUah + closedFlowerCount * pricePerFlowerUah * 0.5);
    }
}
