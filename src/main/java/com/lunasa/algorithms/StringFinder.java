package com.lunasa.algorithms;

import java.util.List;

public class StringFinder {

    public String findSecondShortestString(List<String> strings) {
        if (strings.size() < 2) {
            throw new IllegalArgumentException("Not enought elements to find second shortest string");
        }
        String shortest;
        String secondShortest;
        if (strings.get(0).length() < strings.get(1).length()) {
            shortest = strings.get(0);
            secondShortest = strings.get(1);
        } else {
            shortest = strings.get(1);
            secondShortest = strings.get(0);
        }
        for (int i = 2; i < strings.size(); i++) {
            String s = strings.get(i);
            if (s.length() <= shortest.length()) {
                secondShortest = shortest;
                shortest = s;
            } else if (s.length() <= secondShortest.length()) {
                secondShortest = s;
            }
        }
        return secondShortest;
    }
}
