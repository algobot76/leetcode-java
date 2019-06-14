package com.algobot76.leetcode._207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Topological Order
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int) edges[count].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    q.add(pointer);
                }
            }
        }

        return count == numCourses;
    }
}
