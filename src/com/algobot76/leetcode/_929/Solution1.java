package com.algobot76.leetcode._929;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int numUniqueEmails(String[] emails) {
        Set<String> visited = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            visited.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return visited.size();
    }
}
