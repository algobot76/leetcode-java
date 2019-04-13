package com.algobot76.leetcode._682;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack
 */
public class Solution1 {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
