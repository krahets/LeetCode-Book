/*
* File: lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list;

import include.*;
import java.util.*;

// ===== Solution Code =====
    // 打印中序遍历
    void dfs(Node root) {
        if (root == null) return;
        dfs(root.left); // 左
        System.out.println(root.val); // 根
        dfs(root.right); // 右
    }

public class lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Simple BST
        TreeNode root = TreeNode.arrToTree(new Integer[]{4, 2, 5, 1, 3});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.treeToDoublyList(root);
        System.out.println("Head value:" + " " + (result != null ? result.val : null));

    }
}
