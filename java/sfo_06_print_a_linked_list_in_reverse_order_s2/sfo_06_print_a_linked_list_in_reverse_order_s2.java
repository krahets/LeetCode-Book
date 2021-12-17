/*
* File: sfo_06_print_a_linked_list_in_reverse_order_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_06_print_a_linked_list_in_reverse_order_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
    return res;
    }
}

public class sfo_06_print_a_linked_list_in_reverse_order_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 3, 2 });
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.reversePrint(head);
        System.out.println(Arrays.toString(res));
    }
}
