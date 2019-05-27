package com.algobot76.leetcode._490;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class Solution1 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = curr[0];
                int ny = curr[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx -= dx[dir];
                ny -= dy[dir];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
