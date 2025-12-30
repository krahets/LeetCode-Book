/*
* File: lc_236_lowest_common_ancestor_of_binary_tree_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_236_lowest_common_ancestor_of_binary_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null) return right;
            if(right == null) return left;
            return root;
        }
    }

public class lc_236_lowest_common_ancestor_of_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(result);

    }
}
