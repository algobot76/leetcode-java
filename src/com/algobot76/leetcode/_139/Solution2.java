package com.algobot76.leetcode._139;

import java.util.*;

/**
 * BFS
 */
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.offer(0);
        while (!q.isEmpty()) {
            int l = q.poll();
            if (!visited[l]) {
                for (int r = l + 1; r <= s.length(); r++) {
                    if (dict.contains(s.substring(l, r))) {
                        q.offer(r);
                        if (r == s.length()) {
                            return true;
                        }
                    }
                }
                visited[l] = true;
            }
        }

        return false;
    }
}
