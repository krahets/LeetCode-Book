package include;

import java.util.List;

/**
 * Definition for a singly-linked list node.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode arrToLinkedList(int[] arr) {
        ListNode dum = new ListNode(0);
        ListNode head = dum;
        for (int val : arr) {
            head.next = new ListNode(val);
            head = head.next;
        }
        return dum.next;
    }

    public static ListNode getListNode(ListNode head, int val) {
        while (head != null && head.val != val) {
            head = head.next;
        }
        return head;
    }
}
