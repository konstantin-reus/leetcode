package com.reus.leetcode;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings s = new MultiplyStrings();
//        System.out.println(s.multiply("123456789", "987654321"));
        s.add("944977892635269", "9876543120000000");
    }

    public String multiply(String num1, String num2) {
        String sh = num1.length() < num2.length()
                ? num1
                : num2;
        String lo = num1.length() >= num2.length()
                ? num1
                : num2;
        char[] shorter = sh == num1
                ? num1.toCharArray()
                : num2.toCharArray();
        char[] longer = sh == num2
                ? num1.toCharArray()
                : num2.toCharArray();

        String acc = new String();
        int curPow = 0;
        for (int i = shorter.length - 1; i >= 0; i--) {
            acc = combine(acc, lo, Character.getNumericValue(shorter[i]), curPow++);
        }
        acc = trimZeroes(acc);
        return acc;
    }

    private String trimZeroes(String s) {
        int i = 0;
        boolean changed = false;
        while (i + 1 < s.length() && s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
            changed = true;
            i++;
        }
        if (changed && i == s.length() - 1) {
            return "0";
        } else {
            return s.substring(i, s.length());
        }
    }

    private String combine(String cur, String longer, int multiplier, int pow) {
        String toAdd = multiply(longer, multiplier, pow);
        String result = add(cur, toAdd);
        return result;
    }

    private String add(String s1, String s2) {
        String shorter = s1.length() < s2.length()
                ? s1
                : s2;
        String longer = s1 == shorter
                ? s2
                : s1;
        int overflow = 0;
        StringBuilder result = new StringBuilder();
        for (int i = shorter.length() - 1; i >= 0; i--) {
            int longerIndex = i + longer.length() - shorter.length();
            int toAdd = Character.getNumericValue(shorter.charAt(i)) + Character.getNumericValue(longer.charAt(longerIndex)) + overflow;
            if (overflow > 0) {
                overflow--;
            }

            if (toAdd >= 10) {
                overflow++;
                toAdd %= 10;
            }
            result.append(toAdd);
        }
        for (int i = longer.length() - shorter.length() - 1; i >= 0; i--) {
            int toAdd = Character.getNumericValue(longer.charAt(i)) + overflow;
            if (overflow > 0) {
                overflow--;
            }
            if (toAdd >= 10) {
                overflow++;
                toAdd %= 10;
            }
            result.append(toAdd);
        }
        if (overflow > 0) {
            result.append(overflow);
        }
        result.reverse();
        return result.toString();
    }

    private String multiply(String longer, int multiplier, int pow) {
        char[] c = longer.toCharArray();
        StringBuilder result = new StringBuilder();
        int overflow = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int add = Character.getNumericValue(c[i]) * multiplier + overflow;
            overflow = 0;
            overflow += add / 10;
            add %= 10;
            result.append(add);
        }
        if (overflow > 0) {
            result.append(overflow);
        }
        result.reverse();
        for (int i = 0; i < pow; i++) {
            result.append('0');
        }
        return result.toString();
    }
}
