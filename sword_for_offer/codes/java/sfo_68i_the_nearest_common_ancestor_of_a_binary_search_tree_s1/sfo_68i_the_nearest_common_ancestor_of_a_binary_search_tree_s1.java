/*
* File: sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }
}

public class sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s1 {
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
