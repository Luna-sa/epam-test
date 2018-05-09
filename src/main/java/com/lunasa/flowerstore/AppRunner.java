package com.lunasa.flowerstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lunasa.flowerstore.services.StoreService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppRunner {

    private static final Pattern exp = Pattern.compile("^\\s*([labc])\\s*(\\w+)?\\s*(\\d+)?\\s*(\\d+)?\\s*$");

    private StoreService storeService;

    public AppRunner(StoreService storeService) {
        this.storeService = storeService;
    }

    private void printObject(Object o) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(o);
        System.out.println(json);
    }

    private void listBouquets(Matcher m) {
        String type = m.group(2);
        if (type == null) {
            printObject(storeService.getAllBouquets());
        } else {
            printObject(storeService.getAllBouquetsOfType(type));
        }
    }

    private void addToCart(Matcher m) {
        String userId = m.group(2);
        if (m.group(3) == null || m.group(4) == null) {
            System.out.println("Wrong command");
            return;
        }
        String bouquetId = m.group(3);
        int count = Integer.parseInt(m.group(4));
        storeService.addBouquetToCart(userId, bouquetId, count);
        System.out.println("Successfully added bouquet to cart");
        viewCart(m);
    }

    private void viewCart(Matcher m) {
        String userId = m.group(2);
        printObject(storeService.getBouquetsFromCart(userId));
    }

    private void buyCart(Matcher m) {
        String userId = m.group(2);
        storeService.buyFromCart(userId);
        System.out.println("Successfully bought flowers from cart");
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Available commands:");
        System.out.println("- List all bouquets: l");
        System.out.println("- List all bouquets of type 'rose': l rose");
        System.out.println("- Add to cart for user 'vasya' 3 flowers with ID '1': a vasya 1 3");
        System.out.println("- View cart for user 'vasya': c vasya");
        System.out.println("- Buy the cart for user 'vasya': b vasya");
        System.out.println("(Note 'vasya' has no money, others have infinite)");
        System.out.println("Enter a command:");
        while(scan.hasNextLine()) {
            try {
                String line = scan.nextLine();
                Matcher m = exp.matcher(line);
                if (m.matches()) {
                    switch(m.group(1)) {
                        case "l":
                            listBouquets(m);
                            break;
                        case "a":
                            addToCart(m);
                            break;
                        case "c":
                            viewCart(m);
                            break;
                        case "b":
                            buyCart(m);
                            break;
                    }
                } else {
                    System.out.println("Don't recognize the command");
                }
                System.out.println("Enter a command:");
            } catch (Exception e) {
                System.out.println("Error processing command");
                System.out.println(e.getMessage());
            }
        }
    }
}
