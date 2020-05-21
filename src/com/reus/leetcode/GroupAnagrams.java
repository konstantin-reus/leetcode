package com.reus.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            m.putIfAbsent(sorted, new ArrayList<>());
            m.get(sorted).add(s);
        }
        return m.values().stream().collect(Collectors.toList());
    }
}
