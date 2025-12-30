/*
* File: lc_138_copy_list_with_random_pointer_s5.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_138_copy_list_with_random_pointer;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node cur = head;
            // 1. 复制各节点，并构建拼接链表
            while(cur != null) {
                Node tmp = new Node(cur.val);
                tmp.next = cur.next;
                cur.next = tmp;
                cur = tmp.next;
            }
            // 2. 构建各新节点的 random 指向
            cur = head;
            while(cur != null) {
                if(cur.random != null)
                    cur.next.random = cur.random.next;
                cur = cur.next.next;
            }
            // 3. 拆分两链表
            cur = head.next;
            Node pre = head, res = head.next;
            while(cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null; // 单独处理原链表尾节点
            return res;      // 返回新链表头节点
        }
    }

public class lc_138_copy_list_with_random_pointer_s5 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.copyRandomList(...)
        // print(result)

    }
}
