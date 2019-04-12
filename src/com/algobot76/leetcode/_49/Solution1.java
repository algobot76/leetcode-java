package com.algobot76.leetcode._49;

import java.util.*;

/**
 * Categorize by Sorted String
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
    }
}
