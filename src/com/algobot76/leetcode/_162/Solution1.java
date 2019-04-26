package com.algobot76.leetcode._162;

/**
 * Binary Search
 */
public class Solution1 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (left == mid) {
                return nums[left] < nums[right] ? right : left;
            }
            left = nums[mid] < nums[mid + 1] ? mid : left;
            right = nums[mid] > nums[mid + 1] ? mid : right;
        }
        return 0;
    }
}
