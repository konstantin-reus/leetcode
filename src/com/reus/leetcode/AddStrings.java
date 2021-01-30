package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * https://leetcode.com/problems/add-strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        Map<Character, Integer> nums = new HashMap<>();
        nums.put('0', 0);
        nums.put('1', 1);
        nums.put('2', 2);
        nums.put('3', 3);
        nums.put('4', 4);
        nums.put('5', 5);
        nums.put('6', 6);
        nums.put('7', 7);
        nums.put('8', 8);
        nums.put('9', 9);

        String bigS = num2.length() > num1.length()
                ? num2
                : num1;
        String shortS = bigS.equals(num2)
                ? num1
                : num2;
        char[] bigger = bigS.toCharArray();
        char[] shorter = shortS.toCharArray();
        StringBuilder result = new StringBuilder();
        int tens = 0;

        int s = shorter.length - 1;
        for (int i = bigger.length - 1; i >= 0; i--) {
            int toAppend = i > bigger.length - shorter.length - 1
                    ? nums.get(shorter[s--]) + nums.get(bigger[i])
                    : nums.get(bigger[i]);
            if (tens > 0) {
                toAppend++;
                tens--;
            }
            if (toAppend >= 10) {
                tens += toAppend / 10;
            }
            result.insert(0, toAppend % 10);
        }
        if (tens > 0) {
            result.insert(0, tens);
        }
        return result.toString();
    }
}
