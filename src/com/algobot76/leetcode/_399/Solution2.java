package com.algobot76.leetcode._399;

import java.util.HashMap;
import java.util.Map;

/**
 * Union Find
 */
public class Solution2 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> map = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            if (!root.containsKey(x)) {
                root.put(x, x);
                map.put(x, 1.0);
            }
            if (!root.containsKey(y)) {
                root.put(y, y);
                map.put(y, 1.0);
            }
            String root1 = find(root, map, x);
            String root2 = find(root, map, y);
            root.put(root1, root2);
            map.put(root1, map.get(y) * values[i] / map.get(x));
        }
        for (int i = 0; i < queries.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!root.containsKey(x) || !root.containsKey(y) || !find(root, map, x).equals(find(root, map, y))) {
                ans[i] = -1.0;
            } else {
                ans[i] = map.get(x) / map.get(y);
            }
        }

        return ans;
    }

    private String find(Map<String, String> root, Map<String, Double> map, String s) {
        if (root.get(s).equals(s)) {
            return s;
        }
        String prev = root.get(s);
        String p = find(root, map, root.get(s));
        root.put(s, p);
        map.put(s, map.get(prev) * map.get(s));
        return p;
    }
}
