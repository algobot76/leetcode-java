package com.algobot76.leetcode._49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Categorize by Count (Optimized)
 */
public class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List> ans = new HashMap<>();

        for (String str : strs) {
            int key = 1;
            for (char ch : str.toCharArray()) {
                key *= primes[ch - 'a'];
            }
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
    }
}
