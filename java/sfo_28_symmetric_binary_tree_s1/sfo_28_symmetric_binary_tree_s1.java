/*
* File: sfo_28_symmetric_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_28_symmetric_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}

public class sfo_28_symmetric_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 1, 2, 2, 3, 4, 4, 3, null, null, null, null, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isSymmetric(root);
        System.out.println(res);
    }
}
