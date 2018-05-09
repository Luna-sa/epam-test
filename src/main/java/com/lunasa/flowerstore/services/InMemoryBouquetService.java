package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.LilyBouquet;
import com.lunasa.flowerstore.models.RoseBouquet;

import java.util.Arrays;
import java.util.List;

public class InMemoryBouquetService implements BouquetService {

    private List<Bouquet> allBouquets = Arrays.asList(
        new Bouquet(
            "1",
            "A usual bouquet",
            "iris",
            "Cheap and beautiful",
            7,
            20,
            "https://florina.kh.ua/image/cache/catalog/cvety-kharkov/dostavka-irisov-kharkov/irisy-vesennyaya-progulka-360x360.jpg"
        ),
        new RoseBouquet(
            "2",
            "A hundred red roses",
            "A nice way to waste money",
            100,
            30,
            "short",
            "https://florina.kh.ua/image/cache/catalog/categories/rozy-300x300.jpg"
        ),
        new LilyBouquet(
            "3",
            "Lily for love",
            "It is good for you",
            15,
            25,
            5,
            "https://florina.kh.ua/image/cache/catalog/cvety-kharkov/dostavka-lilij-kharkov/lilii-vzaimnost-360x360.jpg"
        )
    );

    @Override
    public List<Bouquet> getAllBouquets() {
        return allBouquets;
    }
}
