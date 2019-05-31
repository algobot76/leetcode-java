package com.algobot76.leetcode._399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Graph + DFS
 */
public class Solution1 {
    private Map<String, HashMap<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            double z = values[i];
            graph.computeIfAbsent(x, k -> new HashMap<>()).put(y, z);
            graph.computeIfAbsent(y, k -> new HashMap<>()).put(x, 1.0 / z);
        }
        for (int i = 0; i < queries.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, new HashSet<>());
            }
        }

        return ans;
    }

    private double divide(String x, String y, Set<String> visited) {
        if (x.equals(y)) {
            return 1.0;
        }
        visited.add(x);
        for (String k : graph.get(x).keySet()) {
            if (visited.contains(k)) {
                continue;
            }
            visited.add(k);
            double z = divide(k, y, visited);
            if (z > 0) {
                return z * graph.get(x).get(k);
            }
        }

        return -1.0;
    }
}
