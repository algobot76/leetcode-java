package com.algobot76.leetcode._394;

/**
 * DFS
 */
public class Solution2 {
    private int i = 0;

    public String decodeString(String s) {
        char[] input = s.toCharArray();
        StringBuilder ans = new StringBuilder();

        int repeat = 0;
        while (i < input.length) {
            char ch = input[i];
            if (ch == '[') {
                i++;
                String sub = decodeString(s);
                for (int j = 0; j < repeat; j++) {
                    ans.append(sub);
                }
                repeat = 0;
                i++;
            } else if (ch == ']') {
                return ans.toString();
            } else if (Character.isDigit(ch)) {
                repeat = repeat * 10 + ch - '0';
                i++;
            } else {
                ans.append(ch);
                i++;
            }
        }

        return ans.toString();
    }
}
