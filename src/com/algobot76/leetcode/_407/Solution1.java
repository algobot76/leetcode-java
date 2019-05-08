package com.algobot76.leetcode._407;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution1 {
    public int trapRainWater(int[][] heightMap) {
        int water = 0;
        if (heightMap == null || heightMap.length == 0) {
            return water;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;

        Queue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.h));
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Cell(0, i, heightMap[0][i]));
            minHeap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                minHeap.offer(new Cell(nx, ny, Math.max(cell.h, heightMap[nx][ny])));
                water += Math.max(0, cell.h - heightMap[nx][ny]);
            }
        }

        return water;
    }

    class Cell {
        int x;
        int y;
        int h;

        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
