package com.algobot76.leetcode._215;

import java.util.Arrays;

/**
 * Sort
 */
public class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
}
