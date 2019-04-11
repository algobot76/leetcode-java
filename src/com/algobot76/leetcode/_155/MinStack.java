package com.algobot76.leetcode._155;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
    }

    public void push(int x) {
        if (min.isEmpty()) {
            min.push(x);
        } else if (x <= getMin()) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == getMin()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
