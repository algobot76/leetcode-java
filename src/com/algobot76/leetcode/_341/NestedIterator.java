package com.algobot76.leetcode._341;

import com.algobot76.leetcode.util.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        pushList(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushList(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void pushList(List<NestedInteger> nestedList) {
        Deque<NestedInteger> buffer = new ArrayDeque<>();
        for (NestedInteger ni : nestedList) {
            buffer.push(ni);
        }
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}