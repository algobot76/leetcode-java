package com.algobot76.leetcode._482;

public class Solution1 {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("[-]", "");
        S = S.toUpperCase();
        StringBuilder res = new StringBuilder();
        res.append(S);
        int i = res.length() - K;
        while (i > 0) {
            res.insert(i, '-');
            i -= K;
        }

        return res.toString();
    }
}
