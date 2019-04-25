package com.algobot76.leetcode._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sorting + 2Sum
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return triplets;
        }

        Arrays.sort(nums);
        for (int i = 2; i < len; i++) {
            if (i + 1 < len && nums[i] == nums[i + 1]) {
                continue;
            }
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    triplets.add(Arrays.asList(nums[start], nums[end], nums[i]));
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return triplets;
    }
}
