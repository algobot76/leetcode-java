package com.algobot76.leetcode._3;

/**
 * Sliding Window (ASCII)
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int i = 0;
        int[] index = new int[128];

        for (int j = 0; j < s.length(); j++) {
            i = Math.max(index[s.charAt(j)], i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return maxLen;
    }
}
