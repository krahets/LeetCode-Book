/*
* File: lc_235_lowest_common_ancestor_of_bst_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_235_lowest_common_ancestor_of_bst;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                    root = root.right; // 遍历至右子节点
                else if (root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                    root = root.left; // 遍历至左子节点
                else break;
            }
            return root;
        }
    }

public class lc_235_lowest_common_ancestor_of_bst_s1 {
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
