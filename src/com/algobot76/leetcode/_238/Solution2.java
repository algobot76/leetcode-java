package com.algobot76.leetcode._238;

public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        for (int i = 0, temp = 1; i < len; i++) {
            ans[i] = temp;
            temp *= nums[i];
        }
        for (int i = len - 1, temp = 1; i >= 0; i--) {
            ans[i] *= temp;
            temp *= nums[i];
        }

        return ans;
    }
}
