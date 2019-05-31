package com.algobot76.leetcode._305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Union Find
 */
public class Solution1 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if (positions.length == 0) {
            return ans;
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] islands = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (islands[x][y] != 1) {
                count++;
                islands[x][y] = 1;
                int id = convertToId(x, y, n);
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 & nx < m && ny >= 0 && ny < n && islands[nx][ny] == 1) {
                        int nid = convertToId(nx, ny, n);
                        int p = uf.find(id);
                        int np = uf.find(nid);
                        if (p != np) {
                            count--;
                            uf.union(p, np);
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    private int convertToId(int x, int y, int n) {
        return x * n + y;
    }

    class UnionFind {
        private Map<Integer, Integer> parents;

        UnionFind(int m, int n) {
            parents = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = convertToId(i, j, n);
                    parents.put(id, id);
                }
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

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parents.put(px, py);
            }
        }
    }
}
