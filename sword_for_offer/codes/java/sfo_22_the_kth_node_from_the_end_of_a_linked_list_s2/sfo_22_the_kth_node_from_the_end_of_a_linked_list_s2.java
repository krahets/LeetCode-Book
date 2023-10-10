/*
* File: sfo_22_the_kth_node_from_the_end_of_a_linked_list_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_22_the_kth_node_from_the_end_of_a_linked_list_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++) {
            if(former == null) return null;
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}

public class sfo_22_the_kth_node_from_the_end_of_a_linked_list_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 2, 3, 4, 5 });
        int k = 2;
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.getKthFromEnd(head, k);
        PrintUtil.printLinkedList(res);
    }
}
