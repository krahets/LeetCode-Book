/*
* File: lc_103_binary_tree_zigzag_level_order_traversal_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_103_binary_tree_zigzag_level_order_traversal;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) tmp.addLast(node.val);
                    else tmp.addFirst(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }

public class lc_103_binary_tree_zigzag_level_order_traversal_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.zigzagLevelOrder(root);
        System.out.println(result);

    }
}
