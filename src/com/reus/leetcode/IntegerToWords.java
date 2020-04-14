package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWords {
    private static final Map<Integer, String> modifier = new HashMap<>();
    private static final Map<Integer, String> teens = new HashMap<>();
    private static final Map<Integer, String> tens = new HashMap<>();
    private static final Map<Integer, String> digits = new HashMap<>();

    static {
        modifier.put(0, "");
        modifier.put(1, "Thousand");
        modifier.put(2, "Million");
        modifier.put(3, "Billion");

        teens.put(11, "Eleven");
        teens.put(12, "Twelve");
        teens.put(13, "Thirteen");
        teens.put(14, "Fourteen");
        teens.put(15, "Fifteen");
        teens.put(16, "Sixteen");
        teens.put(17, "Seventeen");
        teens.put(18, "Eighteen");
        teens.put(19, "Nineteen");

        tens.put(0, "");
        tens.put(10, "Ten");
        tens.put(20, "Twenty");
        tens.put(30, "Thirty");
        tens.put(40, "Forty");
        tens.put(50, "Fifty");
        tens.put(60, "Sixty");
        tens.put(70, "Seventy");
        tens.put(80, "Eighty");
        tens.put(90, "Ninety");

        digits.put(0, "");
        digits.put(1, "One");
        digits.put(2, "Two");
        digits.put(3, "Three");
        digits.put(4, "Four");
        digits.put(5, "Five");
        digits.put(6, "Six");
        digits.put(7, "Seven");
        digits.put(8, "Eight");
        digits.put(9, "Nine");
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToWords().numberToWords(1_000_000));
        System.out.println(new IntegerToWords().numberToWords(100_000));
        System.out.println(new IntegerToWords().numberToWords(1_000));
        System.out.println(new IntegerToWords().numberToWords(12345));

    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        boolean isFinished = false;
        int counter = 0;
        while (!isFinished) {
            result = result.trim();
            String s = getPart(num % 1000).trim();
            if (!s.isEmpty()) {
                result = result.isEmpty()
                        ? s + " " + getModifier(counter++)
                        : s + " " + getModifier(counter++) + " " + result;
            } else {
                counter++;
            }
            num /= 1000;
            if (num == 0) {
                isFinished = true;
            }
        }
        return result.trim();
    }

    private String getModifier(int counter) {
        if (counter == 0) {
            return "";
        } else {
            return modifier.get(counter);
        }
    }

    private String getPart(int num) {
        if (num == 0) {
            return "";
        }
        int hundreds = num / 100;
        int tensInPart = num % 100;
        if (digits.containsKey(num)) {
            return digits.get(num);
        } else if (teens.containsKey(tensInPart)) {
            return hundreds == 0
                    ? teens.get(tensInPart)
                    : digits.get(hundreds) + " Hundred " + teens.get(tensInPart);
        } else if (tens.containsKey(tensInPart)) {
            return hundreds == 0
                    ? tens.get(tensInPart)
                    : digits.get(hundreds) + " Hundred " + tens.get(tensInPart);
        } else {
            return hundreds == 0
                    ? tensInPart / 10 == 0
                    ? digits.get(tensInPart % 10)
                    : tens.get(tensInPart / 10 * 10) + " " + digits.get(tensInPart % 10)

                    : tensInPart / 10 == 0
                    ? digits.get(hundreds) + " Hundred " + digits.get(tensInPart % 10)
                    : digits.get(hundreds) + " Hundred " + tens.get(tensInPart / 10 * 10) + " " + digits.get(tensInPart % 10);
        }
    }
}
