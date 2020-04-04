package com.reus.leetcode;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int p1 = n;
        int p2 = n;
        boolean isDone = false;
        while (!isDone) {
            p1 = getSquaresSum(p1);
            p2 = getSquaresSum(getSquaresSum(p2));
            if (p1 == p2 && p1 == 1) {
                return true;
            } else if (p1 == p2) {
                return false;
            }
        }
        return false;
    }

    private int getSquaresSum(int n) {
        int result = 0;
        boolean isDone = false;
        while (!isDone) {
            result += (n % 10) * (n % 10);
            n /= 10;
            if (n == 0) {
                isDone = true;
            }
        }
        return result;
    }
}
