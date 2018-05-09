package com.lunasa.flowerstore.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lunasa.flowerstore.exceptions.NoCartException;
import com.lunasa.flowerstore.exceptions.UnknownBouquetException;
import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.BouquetData;
import com.lunasa.flowerstore.models.BouquetSupply;
import com.lunasa.flowerstore.models.UserCart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStoreService implements StoreService {

    private BouquetService bouquetService;

    public InMemoryStoreService(BouquetService bouquetService, PaymentService paymentService) {
        this.bouquetService = bouquetService;
        this.paymentService = paymentService;
    }

    private PaymentService paymentService;

    private Map<String, UserCart> userCarts = new HashMap<>();

    @Override
    public List<Bouquet> getAllBouquets() {
        return bouquetService.getAllBouquets();
    }

    @Override
    public void exportAllBouquets(String fileName) throws IOException {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Bouquet> bouquets = bouquetService.getAllBouquets();
            // Need to convert to BouquetData to include all variables in Rose and Lily Bouquets
            List<BouquetData> data = new ArrayList<>();
            for (int i = 0; i < bouquets.size(); i++) {
                Bouquet b = bouquets.get(i);
                BouquetData d = BouquetData.convertFromBouquet(b);
                data.add(d);
            }
            gson.toJson(data, writer);
        }
    }

    @Override
    public List<Bouquet> getAllBouquetsOfType(String type) {
        List<Bouquet> allBouquets = bouquetService.getAllBouquets();
        List<Bouquet> sameTypeBouquets = new ArrayList<>();
        for (int i = 0; i < allBouquets.size(); i++) {
            Bouquet b = allBouquets.get(i);
            if (b.getType().equals(type)) {
                sameTypeBouquets.add(b);
            }
        }
        return sameTypeBouquets;
    }

    private Bouquet findBouquetForId(String bouquetId) {
        List<Bouquet> allBouquets = bouquetService.getAllBouquets();
        for (int i = 0; i < allBouquets.size(); i++) {
            Bouquet b = allBouquets.get(i);
            if (b.getBouquetId().equals(bouquetId)) {
                return b;
            }
        }
        throw new UnknownBouquetException(bouquetId);
    }

    @Override
    public void addBouquetToCart(String userId, String bouquetId, int count) {
        Bouquet bouquet = findBouquetForId(bouquetId);
        UserCart userCart = userCarts.get(userId);
        if (userCart == null) {
            userCart = new UserCart();
            userCarts.put(userId, userCart);
        }
        userCart.add(bouquet, count);
    }

    @Override
    public List<BouquetSupply> getBouquetsFromCart(String userId) {
        UserCart userCart = userCarts.get(userId);
        if (userCart == null) {
            return new ArrayList();
        }
        return userCart.getBouquets();
    }

    @Override
    public void buyFromCart(String userId) {
        UserCart userCart = userCarts.get(userId);
        if (userCart == null) {
            throw new NoCartException(userId);
        }
        int totalPriceUah = userCart.calculateTotalPrice();
        paymentService.chargeCreditCardForUser(userId, totalPriceUah);
        userCart.clear();
    }
}
