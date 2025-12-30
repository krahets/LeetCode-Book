/*
* File: lc_105_construct_binary_tree_from_preorder_and_inorder_traversal.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_105_construct_binary_tree_from_preorder_and_inorder_traversal;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> dic = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for(int i = 0; i < inorder.length; i++)
                dic.put(inorder[i], i);
            return recur(0, 0, inorder.length - 1);
        }
        TreeNode recur(int root, int left, int right) {
            if (left > right) return null;                          // 递归终止
            TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
            int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
            node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
            node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
            return node;                                           // 回溯返回根节点
        }
    }

public class lc_105_construct_binary_tree_from_preorder_and_inorder_traversal {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_preorder = new int[]{3, 9, 20, 15, 7};
        int[] test_input_inorder = new int[]{9, 3, 15, 20, 7};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.buildTree(test_input_preorder, test_input_inorder);
        print_tree(result)

    }
}
