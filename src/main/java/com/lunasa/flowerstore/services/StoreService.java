package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.BouquetSupply;

import java.io.IOException;
import java.util.List;

public interface StoreService {

    List<Bouquet> getAllBouquets();

    void exportAllBouquets(String fileName) throws IOException;

    List<Bouquet> getAllBouquetsOfType(String type);

    void addBouquetToCart(String userId, String bouquetId, int count);

    List<BouquetSupply> getBouquetsFromCart(String userId);

    void buyFromCart(String userId);
}
