package com.algobot76.leetcode._53;

/**
 * Dynamic Programming (Optimized)
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (nums[i] > currSum) {
                currSum = nums[i];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }
}
