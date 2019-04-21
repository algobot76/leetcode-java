package com.algobot76.leetcode._76;

/**
 * Two Pointers
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] sCount = new int[256];
        int[] tCount = new int[256];

        int uniqueChars = 0;
        for (char ch : tc) {
            tCount[ch]++;
            if (tCount[ch] == 1) {
                uniqueChars++;
            }
        }
        int ansL = -1;
        int ansR = -1;
        int currChars = 0;
        for (int l = 0, r = 0; l < sc.length; l++) {
            while (r < sc.length && currChars < uniqueChars) {
                sCount[sc[r]]++;
                if (sCount[sc[r]] == tCount[sc[r]]) {
                    currChars++;
                }
                r++;
            }
            if (currChars == uniqueChars) {
                if (ansL == -1 || r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
            }
            sCount[sc[l]]--;
            if (sCount[sc[l]] == tCount[sc[l]] - 1) {
                currChars--;
            }
        }

        if (ansL == -1) {
            return "";
        }
        return s.substring(ansL, ansR);
    }
}
