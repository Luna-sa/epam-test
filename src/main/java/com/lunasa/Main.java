package com.lunasa;

import com.lunasa.algorithms.StringFinder;
import com.lunasa.calculator.ConsoleCalculator;
import com.lunasa.flowerstore.AppRunner;
import com.lunasa.flowerstore.services.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        runTask1_1();
//        runTask1_2();
        runTask2();
//        runTask3_and_4_1();
//        runTask3_and_4_2();
    }

    public static void runTask3_and_4_2() {
        BouquetService bouquetService = new DatabaseBouquetService();
        PaymentService paymentService = new TestPaymentService();
        StoreService storeService = new InMemoryStoreService(bouquetService, paymentService);
        AppRunner runner = new AppRunner(storeService);
        runner.run();
    }

    public static void runTask3_and_4_1() {
        BouquetService bouquetService = new FileBouquetService();
        PaymentService paymentService = new TestPaymentService();
        StoreService storeService = new InMemoryStoreService(bouquetService, paymentService);
        AppRunner runner = new AppRunner(storeService);
        runner.run();
    }

    public static void runTask2() {
        BouquetService bouquetService = new InMemoryBouquetService();
        PaymentService paymentService = new TestPaymentService();
        StoreService storeService = new InMemoryStoreService(bouquetService, paymentService);
        AppRunner runner = new AppRunner(storeService);
        runner.run();
    }

    // Calculator
    public static void runTask1_1() {
        new ConsoleCalculator(System.in, System.out).run();
    }

    // Second shortest string in array
    public static void runTask1_2() {
        StringFinder finder = new StringFinder();
        assert "234".equals(finder.findSecondShortestString(Arrays.asList(
                "32",
                "234"
        )));
        assert "3245".equals(finder.findSecondShortestString(Arrays.asList(
                "3245",
                "234"
        )));
        assert "123".equals(finder.findSecondShortestString(Arrays.asList(
                "123",
                "1234",
                "12"
        )));
        assert "1234".equals(finder.findSecondShortestString(Arrays.asList(
                "123",
                "12345",
                "1234"
        )));
        assert "1234".equals(finder.findSecondShortestString(Arrays.asList(
                "123",
                "1234",
                "12345"
        )));
        assert "12".equals(finder.findSecondShortestString(Arrays.asList(
                "123",
                "12345",
                "1234",
                "1",
                "12"
        )));
    }

}

