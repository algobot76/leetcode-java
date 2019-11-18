package com.algobot76.leetcode._347;

import java.util.*;

public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Queue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        counts.forEach((num, count) -> {
            pq.offer(new Integer[]{count, num});
            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int num = pq.poll()[1];
            ans.add(num);
        }
        return ans;
    }
}