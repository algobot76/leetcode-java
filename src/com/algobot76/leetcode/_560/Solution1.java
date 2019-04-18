package com.algobot76.leetcode._560;

/**
 * Cumulative Sum
 */
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int[] sum = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < len; start++) {
            for (int end = start + 1; end <= len; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
