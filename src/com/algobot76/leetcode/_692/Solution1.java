package com.algobot76.leetcode._692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Hash Table + Priority Queue
 */
public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        PriorityQueue<Word> queue = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) {
                return a.count - b.count;
            }
            return a.value.compareTo(b.value);
        });
        for (String word : map.keySet()) {
            Word w = new Word(word, map.get(word));
            if (queue.size() <= k) {
                queue.offer(w);
            } else {
                Word top = queue.peek();
                if (w.count == top.count) {
                    if (w.value.compareTo(top.value) < 0) {
                        queue.poll();
                        queue.offer(w);
                    }
                } else if (w.count > top.count) {
                    queue.poll();
                    queue.offer(w);
                } else {
                    continue;
                }
            }
            queue.offer(new Word(word, map.get(word)));
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().value);
        }
        return ans;
    }

    class Word {
        String value;
        int count;

        Word(String value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
