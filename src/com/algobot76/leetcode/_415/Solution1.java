package com.algobot76.leetcode._415;

public class Solution1 {
    public String addStrings(String num1, String num2) {
        String res = "";
        int m = num1.length();
        int n = num2.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int a;
            int b;
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }
            if (j >= 0) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + carry;
            res = (char) (sum % 10 + '0') + res;
            carry = sum / 10;
        }

        return carry == 1 ? "1" + res : res;
    }
}
