package com.algobot76._141;

import com.algobot76.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem is solved by using a hash table.
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null){
            if(visited.contains(head)){
                return true;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
