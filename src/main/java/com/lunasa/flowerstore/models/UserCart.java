package com.lunasa.flowerstore.models;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    private List<BouquetSupply> bouquetsSupply = new ArrayList<>();

    public void add(Bouquet bouquet, int count) {
        bouquetsSupply.add(new BouquetSupply(bouquet, count));
    }

    public int calculateTotalPrice() {
        int price = 0;
        for (int i = 0; i < bouquetsSupply.size(); i++) {
            BouquetSupply b = bouquetsSupply.get(i);
            int count = b.getCount();
            Bouquet bouquet = b.getBouquet();
            price += bouquet.calculatePriceUah() * count;
        }
        return price;
    }

    public void clear() {
        bouquetsSupply = new ArrayList<>();
    }
}
