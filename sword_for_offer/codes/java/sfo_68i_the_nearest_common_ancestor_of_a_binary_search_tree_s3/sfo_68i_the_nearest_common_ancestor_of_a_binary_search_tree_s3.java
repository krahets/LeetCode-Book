/*
* File: sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s3.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s3;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

public class sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5, null, null, null, null, null, null, null, null });
        TreeNode p = TreeNode.getTreeNode(root, 2);
        TreeNode q = TreeNode.getTreeNode(root, 8);
        // ====== Driver Code ======
        Solution slt = new Solution();
        TreeNode res = slt.lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
