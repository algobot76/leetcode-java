package com.algobot76.leetcode._211;

class TrieNode {
    public boolean isWord;
    private TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }

    public void insert(String word, int index) {
        if (word.length() == index) {
            this.isWord = true;
            return;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }

    public TrieNode find(String word, int index) {
        if (word.length() == index) {
            return this;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : children) {
                if (child != null) {
                    TrieNode node = child.find(word, index + 1);
                    if (node != null && node.isWord) {
                        return node;
                    }
                }
            }
        } else {
            int pos = ch - 'a';
            if (children[pos] != null) {
                return children[pos].find(word, index + 1);
            }
        }

        return null;
    }
}

public class WordDictionary {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        root.insert(word, 0);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return node != null && node.isWord;
    }
}
