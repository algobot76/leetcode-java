package com.algobot76.leetcode._560;

/**
 * Accumulative Sum (Optimized)
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
