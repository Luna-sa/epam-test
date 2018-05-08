package com.lunasa;

import com.lunasa.algorithms.StringFinder;
import com.lunasa.calculator.ConsoleCalculator;
import com.lunasa.flowerstore.services.DatabaseBouquetService;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(new FileBouquetService().getAllBouquets());
//        System.out.println(new DatabaseBouquetService().getAllBouquets());

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

