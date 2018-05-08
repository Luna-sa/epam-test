package com.lunasa.flowerstore.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lunasa.flowerstore.exceptions.FileException;
import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.BouquetData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileBouquetService implements BouquetService {

    @Override
    public List<Bouquet> getAllBouquets() {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("D:\\Freelance\\Java\\EpamTest\\src\\main\\resources\\bouquets.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileException(e.getMessage());
        }
        BouquetData[] bouquetsData = gson.fromJson(reader, BouquetData[].class);
        List<Bouquet> bouquets = new ArrayList<>();
        for (int i = 0; i < bouquetsData.length; i++) {
            BouquetData data = bouquetsData[i];
            Bouquet bouquet = data.convertToBouquet();
            bouquets.add(bouquet);
        }
        return bouquets;
    }
}
