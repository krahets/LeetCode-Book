/*
* File: lc_104_maximum_depth_of_binary_tree_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_104_maximum_depth_of_binary_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

public class lc_104_maximum_depth_of_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.maxDepth(root);
        System.out.println(result);

    }
}
