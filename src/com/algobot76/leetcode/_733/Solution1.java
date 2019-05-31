package com.algobot76.leetcode._733;

/**
 * DFS
 */
public class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];
        fill(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;

        if (sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = newColor;
        fill(image, sr - 1, sc, oldColor, newColor);
        fill(image, sr + 1, sc, oldColor, newColor);
        fill(image, sr, sc - 1, oldColor, newColor);
        fill(image, sr, sc + 1, oldColor, newColor);
    }
}
