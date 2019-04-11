package com.algobot76.leetcode._22;

import java.util.ArrayList;
import java.util.List;

/**
 * Brute Force
 */
public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateAll(new char[2 * n], 0, ans);
        return ans;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean isValid(char[] current) {
        int balance = 0;

        for (char ch : current) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
