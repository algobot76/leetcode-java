package com.algobot76.leetcode._289;

public class Solution1 {
    private int REPRODUCTION = -1;
    private int DEATH = 2;

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                changeState(board, i, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == DEATH) {
                    board[i][j] = 0;
                } else if (board[i][j] == REPRODUCTION) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void changeState(int[][] board, int r, int c) {
        int num = numOfNeighbors(board, r, c);
        if (isAlive(board, r, c)) {
            if (num < 2 || num > 3) {
                board[r][c] = DEATH;
            }
        } else {
            if (num == 3) {
                board[r][c] = REPRODUCTION;
            }
        }
    }

    private int numOfNeighbors(int[][] board, int r, int c) {
        int count = 0;

        count += isAlive(board, r, c - 1) ? 1 : 0;
        count += isAlive(board, r, c + 1) ? 1 : 0;
        count += isAlive(board, r + 1, c) ? 1 : 0;
        count += isAlive(board, r - 1, c) ? 1 : 0;
        count += isAlive(board, r - 1, c - 1) ? 1 : 0;
        count += isAlive(board, r + 1, c + 1) ? 1 : 0;
        count += isAlive(board, r + 1, c - 1) ? 1 : 0;
        count += isAlive(board, r - 1, c + 1) ? 1 : 0;

        return count;
    }

    private boolean isAlive(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] > 0;
    }
}
