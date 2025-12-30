/*
* File: lc_103_binary_tree_zigzag_level_order_traversal_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_103_binary_tree_zigzag_level_order_traversal;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) deque.add(root);
            while (!deque.isEmpty()) {
                // 打印奇数层
                List<Integer> tmp = new ArrayList<>();
                for(int i = deque.size(); i > 0; i--) {
                    // 从左向右打印
                    TreeNode node = deque.removeFirst();
                    tmp.add(node.val);
                    // 先左后右加入下层节点
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                res.add(tmp);
                if (deque.isEmpty()) break; // 若为空则提前跳出
                // 打印偶数层
                tmp = new ArrayList<>();
                for(int i = deque.size(); i > 0; i--) {
                    // 从右向左打印
                    TreeNode node = deque.removeLast();
                    tmp.add(node.val);
                    // 先右后左加入下层节点
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                res.add(tmp);
            }
            return res;
        }
    }

public class lc_103_binary_tree_zigzag_level_order_traversal_s2 {
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
