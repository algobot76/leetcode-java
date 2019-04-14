package com.algobot76.leetcode._139;

import java.util.*;

/**
 * Recursion + Memorization
 */
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> mem = new HashMap<>();
        return wordBreakHelper(s, mem, dict);
    }

    private boolean wordBreakHelper(String s, Map<String, Boolean> mem, Set<String> dict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(i)) && wordBreakHelper(s.substring(0, i), mem, dict)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}
