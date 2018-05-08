package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.models.Bouquet;
import java.util.List;

public interface StoreService {

    List<Bouquet> getAllBouquets();

    List<Bouquet> getAllBouquetsOfType(String type);

    void addFlowerToCart(String userId, Bouquet bouquet, int count);

    void buyFromCart(String userId);
}
