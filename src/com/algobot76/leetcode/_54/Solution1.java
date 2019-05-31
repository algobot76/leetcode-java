package com.algobot76.leetcode._54;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulation
 */
public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] seen = new boolean[rows][cols];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0;
        int c = 0;
        int dir = 0;

        for (int i = 0; i < rows * cols; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[dir];
            int cc = c + dc[dir];
            if (0 <= cr && cr < rows && 0 <= cc && cc < cols && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }

        return ans;
    }
}
