package com.algobot76.leetcode._127;

import java.util.*;

/**
 * BFS
 */
public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int len = beginWord.length();
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            for (int s = queue.size(); s > 0; s--) {
                String word = queue.poll();
                char[] ca = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char ch = ca[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) {
                            continue;
                        }
                        ca[i] = c;
                        String temp = new String(ca);
                        if (temp.equals(endWord)) {
                            return steps + 1;
                        }
                        if (!set.contains(temp)) {
                            continue;
                        }
                        set.remove(temp);
                        queue.offer(temp);
                    }
                    ca[i] = ch;
                }
            }
        }

        return 0;
    }
}
