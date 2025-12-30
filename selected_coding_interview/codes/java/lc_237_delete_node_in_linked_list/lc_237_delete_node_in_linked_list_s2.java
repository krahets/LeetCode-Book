/*
* File: lc_237_delete_node_in_linked_list_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_237_delete_node_in_linked_list;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public void deleteNode(ListNode node) {
            // 复制 node.next 到 node
            node.val = node.next.val;
            // 从链表中删除 node.next
            node.next = node.next.next;
        }
    }

public class lc_237_delete_node_in_linked_list_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.deleteNode(...)
        // print(result)

    }
}
