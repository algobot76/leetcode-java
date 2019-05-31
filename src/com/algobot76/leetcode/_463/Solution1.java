package com.algobot76.leetcode._463;

public class Solution1 {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += getPerimeter(grid, i, j);
            }
        }

        return sum;
    }

    private int getPerimeter(int[][] grid, int r, int c) {
        if (!isValidLand(grid, r, c)) {
            return 0;
        }

        int perimeter = 4;

        if (isValidLand(grid, r - 1, c)) {
            perimeter -= 1;
        }
        if (isValidLand(grid, r + 1, c)) {
            perimeter -= 1;
        }
        if (isValidLand(grid, r, c - 1)) {
            perimeter -= 1;
        }
        if (isValidLand(grid, r, c + 1)) {
            perimeter -= 1;
        }

        return perimeter;
    }

    private boolean isValidLand(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            return grid[r][c] == 1;
        }

        return false;
    }
}
