/*
* File: lc_160_intersection_of_two_linked_lists.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_160_intersection_of_two_linked_lists;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
    }

public class lc_160_intersection_of_two_linked_lists {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Two linked lists with intersection
        ListNode headA = ListNode.arrToLinkedList(new int[]{4, 1, 8, 4, 5});
        ListNode headB = ListNode.arrToLinkedList(new int[]{5, 6, 1, 8, 4, 5});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.getIntersectionNode(headA, headB);
        System.out.println("Intersection node value:" + " " + (result != null ? result.val : null));

    }
}
