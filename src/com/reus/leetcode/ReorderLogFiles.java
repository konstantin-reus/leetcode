package com.reus.leetcode;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return new String[0];
        List<String> digs = new ArrayList<>();
        TreeMap<String, TreeSet<String>> lets = new TreeMap<>();
        for (String s : logs) {
            if (isLog(s)) {
                String value = s.substring(s.indexOf(" ") + 1, s.length());
                lets.computeIfAbsent(value, t -> new TreeSet<>()).add(s.substring(0, s.indexOf(" ")));
            } else {
                digs.add(s);
            }
        }
        String[] result = new String[logs.length];
        int c = 0;
        Iterator<Map.Entry<String, TreeSet<String>>> iterator = lets.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, TreeSet<String>> entry = iterator.next();
            TreeSet<String> letPrefixes = entry.getValue();
            Iterator<String> iter = letPrefixes.iterator();
            while (iter.hasNext()) {
                String toAdd = iter.next() + " " + entry.getKey();
                result[c++] = toAdd;
            }
        }
        for (String dig : digs) {
            result[c++] = dig;
        }
        return result;
    }

    private boolean isLog(String s) {
        String[] splitted = s.split(" ");
        return splitted[1].matches("^[a-zA-Z]+");
    }
}
