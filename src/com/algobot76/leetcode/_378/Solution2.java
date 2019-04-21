package com.algobot76.leetcode._378;

/**
 * Binary Search
 */
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];
        while (low + 1 < high) {
            int mid = (high + low) / 2;
            if (countLessOrEqual(matrix, mid) >= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (countLessOrEqual(matrix, low) >= k) {
            return low;
        }

        return high;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;

        for (int[] row : matrix) {
            int start = 0;
            int end = row.length - 1;
            while (start + 1 < end) {
                int mid = (start + end) / 2;
                if (row[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (row[start] > target) {
                count += start;
            } else if (row[end] > target) {
                count += end;
            } else {
                count += row.length;
            }
        }

        return count;
    }
}
