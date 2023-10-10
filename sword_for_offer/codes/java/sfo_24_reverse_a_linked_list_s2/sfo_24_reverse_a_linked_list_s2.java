/*
* File: sfo_24_reverse_a_linked_list_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_24_reverse_a_linked_list_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode reverseList(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }
}

public class sfo_24_reverse_a_linked_list_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 2, 3, 4, 5 });
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.reverseList(head);
        PrintUtil.printLinkedList(res);
    }
}
