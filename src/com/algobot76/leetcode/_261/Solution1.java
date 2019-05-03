package com.algobot76.leetcode._261;

import java.util.HashMap;
import java.util.Map;

/**
 * Union Find
 */
public class Solution1 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.find(a) == uf.find(b)) {
                return false;
            }
            uf.union(a, b);
        }

        return true;
    }

    class UnionFind {
        private Map<Integer, Integer> parents;

        UnionFind(int n) {
            parents = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
            }
        }

        int find(int x) {
            int p = parents.get(x);

            while (p != parents.get(p)) {
                p = parents.get(p);
            }
            while (x != p) {
                int temp = parents.get(x);
                parents.put(x, p);
                x = temp;
            }

            return p;
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            parents.put(pa, pb);
        }
    }
}
