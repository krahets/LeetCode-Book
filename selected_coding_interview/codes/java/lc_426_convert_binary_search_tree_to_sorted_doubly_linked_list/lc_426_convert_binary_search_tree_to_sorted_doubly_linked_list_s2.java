/*
* File: lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        Node pre, head;
        void dfs(Node cur) {
            if (cur == null) return;
            dfs(cur.left);
            if (pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
    }

public class lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.treeToDoublyList(...)
        // print(result)

    }
}
