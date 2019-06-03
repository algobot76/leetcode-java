package com.algobot76.leetcode._200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private boolean isValid(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1';
    }

    private void bfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{x, y});
        grid[x][y] = '0';
        while (!q.isEmpty()) {
            Integer[] point = q.poll();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (isValid(grid, nx, ny)) {
                    q.offer(new Integer[]{nx, ny});
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}
