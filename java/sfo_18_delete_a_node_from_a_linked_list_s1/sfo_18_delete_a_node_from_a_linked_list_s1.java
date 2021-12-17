/*
* File: sfo_18_delete_a_node_from_a_linked_list_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_18_delete_a_node_from_a_linked_list_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}

public class sfo_18_delete_a_node_from_a_linked_list_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 4, 5, 1, 9 });
        int val = 5;
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.deleteNode(head, val);
        PrintUtil.printLinkedList(res);
    }
}
