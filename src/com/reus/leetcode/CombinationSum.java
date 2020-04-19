package com.reus.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {8,7,4,3}, 11));
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        findSums(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }

    private static void findSums(List<List<Integer>> result, List<Integer> curPath, int[] candidates, int target, int curSum, int curIndex) {
        if (curIndex > candidates.length - 1) {
            return;
        }
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            result.add(curPath);
            return;
        }
        int curCandidate = candidates[curIndex];
        // if add cur element
        List<Integer> probablePath2 = new ArrayList<>(curPath);
        probablePath2.add(curCandidate);
        findSums(result, probablePath2, candidates, target, curSum + curCandidate, curIndex);

        //if skip cur element
        List<Integer> probablePath1 = new ArrayList<>(curPath);
        findSums(result, probablePath1, candidates, target, curSum, curIndex + 1);
    }

}
