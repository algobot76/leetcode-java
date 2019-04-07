package com.algobot76._3;

import java.util.HashSet;
import java.util.Set;

/**
 * Sliding Window
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxLen;
    }
}
