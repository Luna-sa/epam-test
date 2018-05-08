package com.lunasa.flowerstore.services;

public interface PaymentService {

    void chargeCreditCardForUser(String userId, int priceUah);
}
