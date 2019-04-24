package com.algobot76.leetcode._41;

public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i]--;
        }
        for (int i = 0; i < len; i++) {
            while (nums[i] != i && nums[i] >= 0 && nums[i] < len && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
