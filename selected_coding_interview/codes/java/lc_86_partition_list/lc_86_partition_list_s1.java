/*
* File: lc_86_partition_list_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_86_partition_list;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smlDummy = new ListNode(0), bigDummy = new ListNode(0);
            ListNode sml = smlDummy, big = bigDummy;
            while (head != null) {
                if (head.val < x) {
                    sml.next = head;
                    sml = sml.next;
                } else {
                    big.next = head;
                    big = big.next;
                }
                head = head.next;
            }
            sml.next = bigDummy.next;
            big.next = null;
            return smlDummy.next;
        }
    }

public class lc_86_partition_list_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic linked list
        ListNode head = ListNode.arrToLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.partition(head, x);
        PrintUtil.printLinkedList(result);

    }
}
