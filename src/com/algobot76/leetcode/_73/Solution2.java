package com.algobot76.leetcode._73;

public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int dummy = -1000000;
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < c; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = dummy;
                        }
                    }
                    for (int k = 0; k < r; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = dummy;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == dummy) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
