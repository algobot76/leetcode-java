package com.algobot76.leetcode._937;

import java.util.Arrays;

public class Solution1 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return null;
        }

        Arrays.sort(logs, (log1, log2) -> {
            int pos1 = log1.indexOf(" ");
            int pos2 = log2.indexOf(" ");
            String id1 = log1.substring(0, pos1);
            String id2 = log2.substring(0, pos2);
            String word1 = log1.substring(pos1 + 1);
            String word2 = log2.substring(pos2 + 1);
            if (Character.isLetter(word1.charAt(0)) && Character.isLetter(word2.charAt(0))) {
                if (word1.equals(word2)) {
                    return id1.compareTo(id2);
                } else {
                    return word1.compareTo(word2);
                }
            } else if (Character.isLetter(word1.charAt(0)) && Character.isDigit(word2.charAt(0))) {
                return -1;
            } else if (Character.isDigit(word1.charAt(0)) && Character.isLetter(word2.charAt(0))) {
                return 1;
            } else {
                return 0;
            }
        });

        return logs;
    }
}
