package com.algobot76.leetcode._239;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k || k == 1) {
            return nums;
        }
        if (nums.length == k) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> list = new LinkedList<>();
        int start = 0;
        for (int i = start; i < k; i++) {
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            start = i + 1;
        }
        for (int i = start; i < nums.length; i++) {
            ans[i - start] = nums[list.peekFirst()];
            while (!list.isEmpty() && list.peekFirst() <= i - k) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }
        ans[ans.length - 1] = list.peekFirst();

        return ans;
    }
}
