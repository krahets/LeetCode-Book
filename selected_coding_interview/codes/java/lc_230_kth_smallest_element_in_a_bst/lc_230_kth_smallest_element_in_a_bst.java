/*
* File: lc_230_kth_smallest_element_in_a_bst.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_230_kth_smallest_element_in_a_bst;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        int res, k;
        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (k == 0) return;
            if (--k == 0) res = root.val;
            dfs(root.right);
        }
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
    }

public class lc_230_kth_smallest_element_in_a_bst {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.kthSmallest(root, 3);
        System.out.println(result);

    }
}
