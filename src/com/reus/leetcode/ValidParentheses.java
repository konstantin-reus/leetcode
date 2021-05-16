package com.reus.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Set<Character> opening = Set.of('(', '[', '{');
        Map<Character, Character> closingToOpening = Map.of(')', '(', ']', '[', '}', '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (opening.contains(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.pop();
                    if (closingToOpening.get(c) != last) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
