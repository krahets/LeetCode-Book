/*
* File: lc_226_invert_binary_tree_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_226_invert_binary_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
            return root;
        }
    }

public class lc_226_invert_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.invertTree(root);
        System.out.println(result);

    }
}
