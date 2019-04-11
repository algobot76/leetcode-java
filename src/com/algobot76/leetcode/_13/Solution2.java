package com.algobot76.leetcode._13;

public class Solution2 {
    public int romanToInt(String s) {
        int index = 0;
        int ans = 0;

        while (index < s.length()) {
            switch (s.charAt(index)) {
                case 'I':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'V') {
                        ans += 4;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'X') {
                        ans += 9;
                        index += 1;
                    } else
                        ans += 1;
                    break;
                case 'X':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'L') {
                        ans += 40;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'C') {
                        ans += 90;
                        index += 1;
                    } else
                        ans += 10;
                    break;
                case 'C':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'D') {
                        ans += 400;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'M') {
                        ans += 900;
                        index += 1;
                    } else
                        ans += 100;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
            index += 1;
        }

        return ans;
    }
}
