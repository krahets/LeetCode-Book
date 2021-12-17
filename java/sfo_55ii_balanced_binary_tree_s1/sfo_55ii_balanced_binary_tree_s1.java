/*
* File: sfo_55ii_balanced_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_55ii_balanced_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

public class sfo_55ii_balanced_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isBalanced(root);
        System.out.println(res);
    }
}
