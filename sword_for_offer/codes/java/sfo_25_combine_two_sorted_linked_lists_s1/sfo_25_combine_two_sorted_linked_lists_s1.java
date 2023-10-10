/*
* File: sfo_25_combine_two_sorted_linked_lists_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_25_combine_two_sorted_linked_lists_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}

public class sfo_25_combine_two_sorted_linked_lists_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode l1 = ListNode.arrToLinkedList(new int[] { 1, 2, 4 });
        ListNode l2 = ListNode.arrToLinkedList(new int[] { 1, 3, 4 });
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.mergeTwoLists(l1, l2);
        PrintUtil.printLinkedList(res);
    }
}
