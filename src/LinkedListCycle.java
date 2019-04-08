import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 *
 * @author Kaitian Xie
 */
public class LinkedListCycle {
    // Hash Table
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> visited = new HashSet<>();
//        while (head != null) {
//            if (visited.contains(head)) {
//                return true;
//            } else {
//                visited.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    // Two Pointers
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
