package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    private static final Map<String, Integer> romanToInt = new HashMap<>();

    static {
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);
        romanToInt.put("IV", 4);
        romanToInt.put("IX", 9);
        romanToInt.put("XL", 40);
        romanToInt.put("XC", 90);
        romanToInt.put("CD", 400);
        romanToInt.put("CM", 900);

    }

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder cur = new StringBuilder(String.valueOf(s.charAt(i)));
            if (i + 1 < s.length() &&
                    romanToInt.get(String.valueOf(s.charAt(i + 1))) > romanToInt.get(String.valueOf(s.charAt(i)))) {
                cur.append(s.charAt(i + 1));
                i++;
            }
            sum += romanToInt.get(cur.toString());
        }
        return sum;
    }
}
