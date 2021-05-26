package com.reus.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
    private static final Map<Integer, List<Character>> digitToLetter = Map.of(
            2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'),
            4, List.of('g', 'h', 'i'),
            5, List.of('j', 'k', 'l'),
            6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'),
            8, List.of('t', 'u', 'v'),
            9, List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(digits, new StringBuilder(), 0, result);
        return result;
    }

    private void dfs(String digits, StringBuilder curStr, int curPos, List<String> result) {
        if (curPos >= digits.length()) {
            result.add(curStr.toString());
            return;
        }
        int curDigit = Integer.parseInt(Character.toString(digits.charAt(curPos)));
        for (char c : digitToLetter.get(curDigit)) {
            StringBuilder appended = new StringBuilder(curStr).append(c);
            dfs(digits, appended, curPos + 1, result);
        }
    }
}
