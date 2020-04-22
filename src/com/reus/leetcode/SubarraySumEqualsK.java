package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1,2,3}, 3));
    }
        public static int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumToCount = new HashMap<>();
            int sum = 0;
            int total = 0;
            for (int i : nums) {
                sum += i;
                if (sum == k) total++;
                Integer prevSums = sumToCount.get(sum - k);
                if (prevSums != null) {
                    total += prevSums;
                }
                sumToCount.putIfAbsent(sum, 0);
                sumToCount.put(sum, sumToCount.get(sum) + 1);
            }
            return total;
        }

}
