package com.algobot76._3;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window (Optimized)
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return maxLen;
    }
}
