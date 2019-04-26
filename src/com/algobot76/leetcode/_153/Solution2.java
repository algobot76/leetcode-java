package com.algobot76.leetcode._153;

/**
 * Binary Search
 */
public class Solution2 {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        return Math.min(findMinHelper(nums, left, mid - 1), findMinHelper(nums, mid, right));
    }
}
