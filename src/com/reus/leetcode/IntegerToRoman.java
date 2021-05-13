package com.reus.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/integer-to-roman
 */
public class IntegerToRoman {
    private static TreeMap<Integer, String> intToRoman = new TreeMap<>();

    static {
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");
    }

    public String intToRoman(int num) {
        int cur = num;
        StringBuilder result = new StringBuilder();
        while (cur > 0) {
            Map.Entry<Integer, String> closestRoman = intToRoman.floorEntry(cur);
            result.append(closestRoman.getValue());
            cur -= closestRoman.getKey();
        }
        return result.toString();
    }
}
