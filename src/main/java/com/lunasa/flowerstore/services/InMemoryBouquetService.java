package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.models.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBouquetService implements BouquetService {

    private List<Bouquet> allBouquets = new ArrayList<>();

    @Override
    public List<Bouquet> getAllBouquets() {
        return allBouquets;
    }
}
