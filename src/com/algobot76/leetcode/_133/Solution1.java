package com.algobot76.leetcode._133;

import com.algobot76.leetcode.util.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> m = new HashMap<>();
        Node start = new Node()
        q.offer(node);

    }
}
