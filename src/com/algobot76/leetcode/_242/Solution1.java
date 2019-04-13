package com.algobot76.leetcode._242;

import java.util.Arrays;

/**
 * Sorting
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);

        return Arrays.equals(sa, ta);
    }
}
