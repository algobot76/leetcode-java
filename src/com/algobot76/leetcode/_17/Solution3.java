package com.algobot76.leetcode._17;

import java.util.ArrayList;
import java.util.List;

/**
 * BFS
 */
public class Solution3 {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String t : ans) {
                String str = phone[Character.getNumericValue(digit)];
                for (int i = 0; i < str.length(); i++) {
                    temp.add(t + str.charAt(i));
                }
                ans = temp;
            }
        }

        return ans;
    }
}
