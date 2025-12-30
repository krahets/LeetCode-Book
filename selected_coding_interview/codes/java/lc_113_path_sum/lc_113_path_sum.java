/*
* File: lc_113_path_sum.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_113_path_sum;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            recur(root, targetSum);
            return res;
        }
        void recur(TreeNode root, int tar) {
            if (root == null) return;
            path.add(root.val);
            tar -= root.val;
            if (tar == 0 && root.left == null && root.right == null)
                res.add(new LinkedList<Integer>(path));
            recur(root.left, tar);
            recur(root.right, tar);
            path.removeLast();
        }
    }

public class lc_113_path_sum {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        int targetSum = 22;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.pathSum(root, targetSum);
        System.out.println(result);

    }
}
