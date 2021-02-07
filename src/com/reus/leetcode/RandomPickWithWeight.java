package com.reus.leetcode;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {
    private NavigableMap<Double, Integer> probabilityToIndex = new TreeMap<>();

    public RandomPickWithWeight(int[] w) {
        int sum = 0;
        for (int i : w) {
            sum += i;
        }
        for (int i = 0; i < w.length; i++) {
            double probability = w[i] * 1.0 / sum;
            probabilityToIndex.put(probability, i);
        }
    }

    public static void main(String[] args) {
        RandomPickWithWeight r = new RandomPickWithWeight(new int[]{3, 14, 1, 7});
        for (int i = 0; i < 82; i++) {
            System.out.println(r.pickIndex());
        }
    }

    public int pickIndex() {
        double random = new Random().nextDouble();
        Map.Entry<Double, Integer> firstSuggested = probabilityToIndex.ceilingEntry(random);
        if (firstSuggested != null) {
            return firstSuggested.getValue();
        } else {
            return probabilityToIndex.floorEntry(random).getValue();
        }
    }
}
