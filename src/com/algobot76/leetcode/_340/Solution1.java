package com.algobot76.leetcode._340;

/**
 * Two Pointers
 */
public class Solution1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] sc = s.toCharArray();
        int[] count = new int[256];
        int len = 0;
        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            count[sc[r]]++;
            if (count[sc[r]] == 1) {
                len++;
            }
            while (len > k) {
                count[sc[l]]--;
                if (count[sc[l]] == 0) {
                    len--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
