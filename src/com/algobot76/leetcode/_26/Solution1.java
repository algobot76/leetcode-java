package com.algobot76.leetcode._26;

/**
 * Two Pointers
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }

        return size + 1;
    }
}
