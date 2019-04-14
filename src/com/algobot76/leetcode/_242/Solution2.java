package com.algobot76.leetcode._242;

import java.util.Arrays;

/**
 * Sliding Window
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sa = new int[26];
        int[] ta = new int[26];
        for (char ch : s.toCharArray()) {
            sa[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            ta[ch-'a']++;
        }
        if (Arrays.equals(sa, ta)) {
            return true;
        }

        return false;
    }
}
