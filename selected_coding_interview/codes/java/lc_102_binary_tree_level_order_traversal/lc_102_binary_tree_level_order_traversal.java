/*
* File: lc_102_binary_tree_level_order_traversal.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_102_binary_tree_level_order_traversal;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }

public class lc_102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.levelOrder(root);
        System.out.println(result);

    }
}
