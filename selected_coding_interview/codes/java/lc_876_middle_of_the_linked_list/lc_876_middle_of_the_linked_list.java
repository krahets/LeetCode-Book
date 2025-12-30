/*
* File: lc_876_middle_of_the_linked_list.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_876_middle_of_the_linked_list;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

public class lc_876_middle_of_the_linked_list {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic linked list
        ListNode head = ListNode.arrToLinkedList(new int[]{1, 2, 3, 4, 5});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.middleNode(head);
        PrintUtil.printLinkedList(result);

    }
}
