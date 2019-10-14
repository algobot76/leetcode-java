package com.algobot76.leetcode._685;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> nums = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(n -> Math.abs(n - x)))
                .collect(Collectors.toList());
        List<Integer> ans = nums.subList(0, k);
        ans.sort(Comparator.naturalOrder());
        return ans;
    }
}
