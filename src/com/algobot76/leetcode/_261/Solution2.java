package com.algobot76.leetcode._261;

import java.util.*;

/**
 * DFS
 */
public class Solution2 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        q.offer(0);
        s.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer neighbor : graph.get(node)) {
                if (s.contains(neighbor)) {
                    continue;
                }
                s.add(neighbor);
                q.offer(neighbor);
            }
        }

        return s.size() == n;
    }
}
