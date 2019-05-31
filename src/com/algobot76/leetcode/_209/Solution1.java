package com.algobot76.leetcode._209;

/**
 * Two Pointers
 */
public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
