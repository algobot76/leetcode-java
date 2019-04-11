package com.algobot76.leetcode._22;

import java.util.ArrayList;
import java.util.List;

/**
 * Closure Number
 */
public class Solution3 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();

        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }

        return ans;
    }
}
