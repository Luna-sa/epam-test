package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.UserCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStoreService implements StoreService {

    private BouquetService bouquetService;
    private PaymentService paymentService;

    private Map<String, UserCart> userCarts = new HashMap<>();

    public InMemoryStoreService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public List<Bouquet> getAllBouquets() {
        return bouquetService.getAllBouquets();
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

    @Override
    public void addFlowerToCart(String userId, Bouquet bouquet, int count) {
        UserCart userCart = userCarts.get(userId);
        if (userCart == null) {
            userCart = new UserCart();
            userCarts.put(userId, userCart);
        }
        userCart.add(bouquet, count);
    }

    @Override
    public void buyFromCart(String userId) {
        UserCart userCart = userCarts.get(userId);
        if (userCart == null) {
            userCart = new UserCart();
            userCarts.put(userId, userCart);
        }
        int totalPriceUah = userCart.calculateTotalPrice();
        paymentService.chargeCreditCardForUser(userId, totalPriceUah);
        userCart.clear();
    }
}
