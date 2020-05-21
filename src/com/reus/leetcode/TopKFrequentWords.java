package com.reus.leetcode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || k <= 0) return new ArrayList<>();

        Map<String, Integer> wordToFreq = new HashMap<>();
        TreeMap<Integer, Set<String>> freqToWords = new TreeMap<>(Comparator.reverseOrder());
        for (String word : words) {
            int freq = wordToFreq.computeIfAbsent(word, i -> 0) + 1;
            int prevFreq = freq - 1;
            Set<String> prevWordFreq = freqToWords.get(prevFreq);
            if (prevWordFreq != null) {
                prevWordFreq.remove(word);
                freqToWords.get(prevFreq).remove(word);
                if (freqToWords.get(prevFreq).isEmpty()) {
                    freqToWords.remove(prevFreq);
                }
            }
            wordToFreq.put(word, freq);
            freqToWords.computeIfAbsent(freq, i -> new TreeSet<String>()).add(word);
        }
        List<String> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Set<String>>> freqToWordsIter = freqToWords.entrySet().iterator();
        int c = k;

        for (int i = 0; i < k && c > 0; i++) {
            if (!freqToWordsIter.hasNext()) return result;
            Map.Entry<Integer, Set<String>> entry = freqToWordsIter.next();
            Iterator<String> iter = entry.getValue().iterator();
            while (iter.hasNext() && c > 0) {
                result.add(iter.next());
                c--;
            }
        }
        return result;
    }
}
