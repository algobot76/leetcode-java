package com.algobot76.leetcode._17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Backtracking
 */
public class Solution1 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> ans = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            backtrack("", digits);
        }
        return ans;
    }

    private void backtrack(String combination, String digits) {
        if (digits.isEmpty()) {
            ans.add(combination);
        } else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, digits.substring(1));
            }
        }
    }
}
