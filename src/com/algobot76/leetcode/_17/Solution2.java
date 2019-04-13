package com.algobot76.leetcode._17;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 */
public class Solution2 {
    public List<String> letterCombinations(String digits) {
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] curr = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, phone, 0, curr, ans);
        return ans;
    }

    private void dfs(String digits, String[] phone, int idx, char[] curr, List<String> ans) {
        if (idx == digits.length()) {
            if (idx > 0) {
                ans.add(new String(curr));
            }
            return;
        }
        String str = phone[Character.getNumericValue(digits.charAt(idx))];
        for (int i = 0; i < str.length(); i++) {
            curr[idx] = str.charAt(i);
            dfs(digits, phone, idx + 1, curr, ans);
        }
    }
}
