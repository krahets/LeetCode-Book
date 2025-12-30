/*
* File: lc_110_balanced_binary_tree_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_110_balanced_binary_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
        private int depth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

public class lc_110_balanced_binary_tree_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isBalanced(root);
        System.out.println(result);

    }
}
