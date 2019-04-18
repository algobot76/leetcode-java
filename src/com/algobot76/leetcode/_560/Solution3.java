package com.algobot76.leetcode._560;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash Table
 */
public class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
        }
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] - k)) {
                count += map.get(nums[i] - k);
            }
            int temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], temp);
        }

        return count;
    }
}
