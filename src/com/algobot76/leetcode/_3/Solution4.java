package com.algobot76.leetcode._3;

public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return chars.length;
        }
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (++l < chars.length) {
            for (int i = r; i < l; i++) {
                if (chars[l] == chars[i]) {
                    if (l - r > maxLen) {
                        maxLen = l - r;
                    }
                    r = i + 1;
                    break;
                }
            }
        }
        if (l - r > maxLen) {
            maxLen = l - r;
        }
        return maxLen;
    }
}
