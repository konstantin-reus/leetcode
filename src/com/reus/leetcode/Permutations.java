package com.reus.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            traverse(nums, i, new ArrayList<>(), result, new HashSet<Integer>());
        }
        return result;
    }

    private void traverse(int[] nums, int index, List<Integer> subResult, List<List<Integer>> result, Set<Integer> visited) {
        List<Integer> subTreeResult = new ArrayList<>(subResult);
        subTreeResult.add(nums[index]);
        if (subTreeResult.size() == nums.length) {
            result.add(subTreeResult);
            return;
        }
        Set<Integer> subTreeVisited = new HashSet<>(visited);
        subTreeVisited.add(index);
        for (int i = 0; i < nums.length; i++) {
            if (subTreeVisited.contains(i)) continue;
            traverse(nums, i, subTreeResult, result, subTreeVisited);
        }
    }
}
