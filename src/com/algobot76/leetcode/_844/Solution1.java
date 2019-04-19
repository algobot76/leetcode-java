package com.algobot76.leetcode._844;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack
 */
public class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> sStack = new ArrayDeque<>();
        Deque<Character> tStack = new ArrayDeque<>();

        for (char ch : S.toCharArray()) {
            if (ch == '#') {
                if (sStack.size() > 0) {
                    sStack.pop();
                }
            } else {
                sStack.push(ch);
            }
        }
        for (char ch : T.toCharArray()) {
            if (ch == '#') {
                if (tStack.size() > 0) {
                    tStack.pop();
                }
            } else {
                tStack.push(ch);
            }
        }

        if (sStack.size() != tStack.size()) {
            return false;
        }
        while (!sStack.isEmpty()) {
            char sCh = sStack.pop();
            char tCh = tStack.pop();
            if (sCh != tCh) {
                return false;
            }
        }
        return true;
    }
}
