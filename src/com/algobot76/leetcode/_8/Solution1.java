package com.algobot76.leetcode._8;

public class Solution1 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int start = 0;
        int len = str.length();
        long sum = 0;

        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;
    }
}
