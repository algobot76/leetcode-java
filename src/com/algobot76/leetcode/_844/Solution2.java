package com.algobot76.leetcode._844;

/**
 * Two Pointers
 */
public class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int p = S.length() - 1;
        int q = T.length() - 1;
        int sSkip = 0;
        int tSkip = 0;

        while (p >= 0 || q >= 0) {
            while (p >= 0) {
                if (S.charAt(p) == '#') {
                    sSkip++;
                    p--;
                } else if (sSkip > 0) {
                    sSkip--;
                    p--;
                } else {
                    break;
                }
            }
            while (q >= 0) {
                if (T.charAt(q) == '#') {
                    tSkip++;
                    q--;
                } else if (tSkip > 0) {
                    tSkip--;
                    q--;
                } else {
                    break;
                }
            }

            if (p >= 0 && q >= 0 && S.charAt(p) != T.charAt(q)) {
                return false;
            }
            if ((p >= 0 && q < 0) || (p < 0 && q >= 0)) {
                return false;
            }
            p--;
            q--;
        }

        return true;
    }
}
