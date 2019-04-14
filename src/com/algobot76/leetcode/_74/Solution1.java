package com.algobot76.leetcode._74;

/**
 * Binary Search
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            int elem = matrix[pivot / n][pivot % n];
            if (elem == target) {
                return true;
            } else {
                if (elem > target) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }

        return false;
    }
}
