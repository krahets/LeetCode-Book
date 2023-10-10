/*
* File: sfo_24_reverse_a_linked_list_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_24_reverse_a_linked_list_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}

public class sfo_24_reverse_a_linked_list_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        ListNode head = ListNode.arrToLinkedList(new int[] { 1, 2, 3, 4, 5 });
        // ====== Driver Code ======
        Solution slt = new Solution();
        ListNode res = slt.reverseList(head);
        PrintUtil.printLinkedList(res);
    }
}
