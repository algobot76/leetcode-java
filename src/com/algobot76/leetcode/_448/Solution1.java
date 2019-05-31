package com.algobot76.leetcode._448;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            count[num - 1]++;
        }
        for (int i = 0; i < len; i++) {
            if (count[i] == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
