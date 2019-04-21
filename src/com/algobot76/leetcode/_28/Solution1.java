package com.algobot76.leetcode._28;

/**
 * Two Pointers
 */
public class Solution1 {
    public int strStr(String haystack, String needle) {
        String curr;
        int ans = -1;

        for (int l = 0, r = needle.length(); r <= haystack.length(); r++) {
            curr = haystack.substring(l, r);
            if (curr.length() == needle.length()) {
                if (curr.equals(needle)) {
                    ans = l;
                    break;
                } else {
                    l++;
                }
            }
        }

        return ans;
    }
}
