package com.algobot76.leetcode._771;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for (char j : J.toCharArray()) {
            jSet.add(j);
        }

        int count = 0;
        for (char s : S.toCharArray()) {
            if (jSet.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
