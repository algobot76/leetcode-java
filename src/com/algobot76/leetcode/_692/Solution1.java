package com.algobot76.leetcode._692;

import java.util.*;

public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return b.word.compareTo(a.word);
            } else {
                return a.count - b.count;
            }
        });

        counts.forEach((word, count) -> {
            Pair p = new Pair(count, word);
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }

    class Pair {
        int count;
        String word;

        Pair(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
}
