package com.algobot76.leetcode._49;

import java.util.*;

/**
 * Categorize by Count
 */
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
    }
}
