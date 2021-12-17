/*
* File: sfo_06_print_a_linked_list_in_reverse_order_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_06_print_a_linked_list_in_reverse_order_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}

public class sfo_06_print_a_linked_list_in_reverse_order_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 3, 2 });
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.reversePrint(head);
        System.out.println(Arrays.toString(res));
    }
}
