/*
* File: lc_138_copy_list_with_random_pointer_s4.java
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
            Map<Node, Node> map = new HashMap<>();
            // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while(cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            // 4. 构建新链表的 next 和 random 指向
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 5. 返回新链表的头节点
            return map.get(head);
        }
    }

public class lc_138_copy_list_with_random_pointer_s4 {
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
