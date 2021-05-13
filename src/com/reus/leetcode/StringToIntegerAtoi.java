package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {
    private static final Map<Character, Integer> charToInt = new HashMap<>();

    static {
        charToInt.put('0', 0);
        charToInt.put('1', 1);
        charToInt.put('2', 2);
        charToInt.put('3', 3);
        charToInt.put('4', 4);
        charToInt.put('5', 5);
        charToInt.put('6', 6);
        charToInt.put('7', 7);
        charToInt.put('8', 8);
        charToInt.put('9', 9);
    }

    public int myAtoi(String s) {
        String[] split = s.trim().split("\\s");
        char[] chars = split[0].toCharArray();
        boolean isValid = isValid(chars);
        if (!isValid) {
            return 0;
        }
        return buildSum(chars);
    }

    private boolean isValid(char[] chars) {
        if (chars.length == 0) {
            return false;
        }
        boolean digitMet = false;
        boolean signMet = false;
        for (char aChar : chars) {
            boolean isSign = aChar == '-' || aChar == '+';
            boolean isDigit = charToInt.containsKey(aChar);
            if (isSign && !digitMet && !signMet) {
                signMet = true;
            } else if (isSign && signMet && !digitMet) {
                return false;
            } else if (isDigit) {
                return true;
            }
        }
        return true;
    }

    private int buildSum(char[] chars) {
        int countDigits = countDigits(chars);
        int processedDigits = 0;
        int c = 0;
        int curPow = countDigits - 1;
        long sum = 0L;
        boolean isNegative = isNegative(chars);
        while (processedDigits < countDigits && curPow >= 0) {
            if (!charToInt.containsKey(chars[c])) {
                c++;
                continue;
            }
            long toAdd = (long) (charToInt.get(chars[c]) * Math.pow(10, curPow--));
            if (isNegative && Integer.MIN_VALUE + toAdd > sum * -1) {
                return Integer.MIN_VALUE;
            } else if (!isNegative && Integer.MAX_VALUE - sum < toAdd) {
                return Integer.MAX_VALUE;
            }
            sum += toAdd;
            c++;
        }
        if (isNegative) {
            sum *= -1;
        }
        return (int) sum;
    }

    private boolean isNegative(char[] chars) {
        return chars[0] == '-';
    }

    private int countDigits(char[] chars) {
        int c = 0;
        boolean digitsFound = false;
        for (int i = 0; i < chars.length; i++) {
            if (!digitsFound && (chars[i] == ' ' || chars[i] == '+' || (chars[i] == '-'))) {
                continue;
            } else if (!charToInt.containsKey(chars[i])) {
                return c;
            } else {
                digitsFound = true;
                c++;
            }
        }
        return c;
    }
}
