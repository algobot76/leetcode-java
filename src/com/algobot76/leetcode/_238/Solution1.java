package com.algobot76.leetcode._238;

/**
 * Brute Force (Time Limit Exceeded)
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = prod(i, nums);
        }

        return ans;
    }

    private int prod(int i, int[] nums) {
        int result = 1;

        for (int j = 0; j < nums.length; j++) {
            if (j != i) {
                result *= nums[j];
            }
        }

        return result;
    }
}
