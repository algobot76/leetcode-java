package com.algobot76.leetcode._16;

import java.util.Arrays;

/**
 * Sorting + 2Sum
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        int delta = Integer.MAX_VALUE;
        int ans = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currDelta = Math.abs(sum - target);
                if (currDelta == 0) {
                    return sum;
                }
                if (currDelta < delta) {
                    delta = currDelta;
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
