import com.algobot76.leetcode.util.ListNode;

/**
 * 206. Reverse Linked List
 *
 * @author Kaitian Xie
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
