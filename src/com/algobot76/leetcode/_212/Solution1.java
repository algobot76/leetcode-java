package com.algobot76.leetcode._212;

import java.util.ArrayList;
import java.util.List;

/**
 * Trie + DFS
 */
public class Solution1 {
    private List<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int x, int y, TrieNode root) {
        int m = board.length;
        int n = board[0].length;
        char ch = board[x][y];
        int pos = ch - 'a';

        if (ch == '*' || root.children[pos] == null) {
            return;
        }
        TrieNode node = root.children[pos];
        board[x][y] = '*';
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        if (x > 0) {
            dfs(board, x - 1, y, node);
        }
        if (y > 0) {
            dfs(board, x, y - 1, node);
        }
        if (x < m - 1) {
            dfs(board, x + 1, y, node);
        }
        if (y < n - 1) {
            dfs(board, x, y + 1, node);
        }
        board[x][y] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int pos = ch - 'a';
                if (curr.children[pos] == null) {
                    curr.children[pos] = new TrieNode();
                }
                curr = curr.children[pos];
            }
            curr.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
