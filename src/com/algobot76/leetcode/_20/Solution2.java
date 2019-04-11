package com.algobot76.leetcode._20;

/**
 * Stack (Optimized)
 */
public class Solution2 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int ptr = 0;
        char[] map = new char[s.length()];

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    map[ptr++] = ch;
                    break;
                case ')':
                    if (ptr == 0 || map[--ptr] != '(')
                        return false;
                    break;
                case '}':
                    if (ptr == 0 || map[--ptr] != '{')
                        return false;
                    break;
                case ']':
                    if (ptr == 0 || map[--ptr] != '[')
                        return false;
                    break;
            }
        }

        return ptr == 0;
    }
}
