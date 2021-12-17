/*
* File: sfo_55ii_balanced_binary_tree_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_55ii_balanced_binary_tree_s2;

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

public class sfo_55ii_balanced_binary_tree_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isBalanced(root);
        System.out.println(res);
    }
}
