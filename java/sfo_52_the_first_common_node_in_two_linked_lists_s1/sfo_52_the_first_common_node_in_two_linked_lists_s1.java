/*
* File: sfo_52_the_first_common_node_in_two_linked_lists_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_52_the_first_common_node_in_two_linked_lists_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}

public class sfo_52_the_first_common_node_in_two_linked_lists_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Build two linked lists with intersection of 8
        // headA = 4 -> 1 -> 8 -> 4 -> 5
        //                   ↑
        // headB = 5 -> 0 -> 1
        ListNode headA = ListNode.arrToLinkedList(new int[] { 4, 1, 8, 4, 5 });
        ListNode headB = ListNode.arrToLinkedList(new int[] { 5, 0, 1, 8, 4, 5 });
        ListNode intersectA = ListNode.getListNode(headA, 8);
        ListNode intersectB = ListNode.getListNode(headB, 1);
        intersectB.next = intersectA; // Concatenate the two lists
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.getIntersectionNode(headA, headB);
        System.out.println(res.val);
    }
}
