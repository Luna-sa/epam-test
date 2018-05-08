package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.exceptions.InsufficientFundsException;

public class TestPaymentService implements PaymentService {

    @Override
    public void chargeCreditCardForUser(String userId, int priceUah) {
        if (userId == "vasya") {
            throw new InsufficientFundsException(userId);
        }
    }
}
