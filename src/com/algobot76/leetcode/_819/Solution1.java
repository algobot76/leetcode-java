package com.algobot76.leetcode._819;

import java.util.*;

public class Solution1 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        String ans = "";
        for (String word : count.keySet()) {
            int freq = count.get(word);
            if (freq > max) {
                ans = word;
                max = freq;
            }
        }

        return ans;
    }
}
