/*
* File: lc_21_merge_two_sorted_lists.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_21_merge_two_sorted_lists;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dum = new ListNode(0), cur = dum;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                }
                else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            cur.next = list1 != null ? list1 : list2;
            return dum.next;
        }
    }

public class lc_21_merge_two_sorted_lists {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Two sorted linked lists
        ListNode list1 = ListNode.arrToLinkedList(new int[]{1, 2, 4});
        ListNode list2 = ListNode.arrToLinkedList(new int[]{1, 3, 4});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.mergeTwoLists(list1, list2);
        PrintUtil.printLinkedList(result);

    }
}
