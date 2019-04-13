package com.algobot76.leetcode._127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bidirectional BFS
 */
public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        int len = beginWord.length();
        int steps = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            steps++;
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> q = new HashSet<>();
            for (String word : q1) {
                char[] ca = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char ch = ca[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ca[i] = c;
                        String temp = new String(ca);
                        if (q2.contains(temp)) {
                            return steps + 1;
                        }
                        if (!set.contains(temp)) {
                            continue;
                        }
                        set.remove(temp);
                        q.add(temp);
                    }
                    ca[i] = ch;
                }

            }
            q1 = q;
        }

        return 0;
    }
}
