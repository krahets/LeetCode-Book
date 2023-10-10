/*
* File: sfo_68ii_the_nearest_common_ancestor_of_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_68ii_the_nearest_common_ancestor_of_a_binary_tree_s1;

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

public class sfo_68ii_the_nearest_common_ancestor_of_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null, null, null, null, null });
        TreeNode p = TreeNode.getTreeNode(root, 5);
        TreeNode q = TreeNode.getTreeNode(root, 1);
        // ====== Driver Code ======
        Solution slt = new Solution();
        TreeNode res = slt.lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
