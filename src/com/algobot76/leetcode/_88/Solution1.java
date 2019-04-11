package com.algobot76.leetcode._88;

import java.util.Arrays;

public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
