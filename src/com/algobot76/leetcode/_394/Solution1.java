package com.algobot76.leetcode._394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack
 */
public class Solution1 {
    public String decodeString(String s) {
        char[] input = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<String> buffer = new ArrayDeque<>();
        String ans = "";

        int i = 0;
        while (i < input.length) {
            if (Character.isDigit(input[i])) {
                int count = 0;
                while (Character.isDigit(input[i])) {
                    count = count * 10 + input[i] - '0';
                    i++;
                }
                stack.push(count);
                continue;
            } else if (input[i] == '[') {
                buffer.push(ans);
                ans = "";
            } else if (input[i] == ']') {
                StringBuilder sb = new StringBuilder(buffer.pop());
                int repeat = stack.pop();
                for (int j = 0; j < repeat; j++) {
                    sb.append(ans);
                }
                ans = sb.toString();
            } else {
                ans += input[i];
            }
            i++;
        }

        return ans;
    }
}
