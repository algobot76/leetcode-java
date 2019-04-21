package com.algobot76.leetcode._3;

/**
 * Two Pointers
 */
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        char[] input = s.toCharArray();
        int[] count = new int[256];
        int ans = 0;

        for (int l = 0, r = 0; r < input.length; r++) {
            count[input[r]]++;
            while (count[input[r]] > 1) {
                count[input[l++]]--;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
