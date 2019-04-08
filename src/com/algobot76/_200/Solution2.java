package com.algobot76._200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem is solved by using BFS.
 */
class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    bfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        grid[r][c] = '0';

        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.add(r * cols + c);

        while (!neighbors.isEmpty()) {
            int id = neighbors.remove();
            int row = id / cols;
            int col = id % cols;
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                neighbors.add((row - 1) * cols + col);
                grid[row - 1][col] = '0';
            }
            if (row + 1 < rows && grid[row + 1][col] == '1') {
                neighbors.add((row + 1) * cols + col);
                grid[row + 1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                neighbors.add(row * cols + col - 1);
                grid[row][col - 1] = '0';
            }
            if (col + 1 < cols && grid[row][col + 1] == '1') {
                neighbors.add(row * cols + col + 1);
                grid[row][col + 1] = '0';
            }
        }
    }
}