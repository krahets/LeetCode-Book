/*
* File: lc_101_symmetric_tree.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_101_symmetric_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || recur(root.left, root.right);
        }
        boolean recur(TreeNode L, TreeNode R) {
            if (L == null && R == null) return true;
            if (L == null || R == null || L.val != R.val) return false;
            return recur(L.left, R.right) && recur(L.right, R.left);
        }
    }

public class lc_101_symmetric_tree {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isSymmetric(root);
        System.out.println(result);

    }
}
