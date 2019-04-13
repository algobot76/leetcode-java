package com.algobot76.leetcode._48;

/**
 * Rotate four rectangles
 */
public class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] temp = new int[4];
                int r = i;
                int c = j;
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[r][c];
                    int t = r;
                    r = c;
                    c = n - 1 - t;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[r][c] = temp[(k + 3) % 4];
                    int t = r;
                    r = c;
                    c = n - 1 - t;
                }
            }
        }
    }
}
