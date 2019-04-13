package com.algobot76.leetcode._189;

public class Solution1 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len; i++) {
            copy[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = copy[i];
        }
    }
}
