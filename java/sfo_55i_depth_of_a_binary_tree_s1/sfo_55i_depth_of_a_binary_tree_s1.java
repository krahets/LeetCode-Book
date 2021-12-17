/*
* File: sfo_55i_depth_of_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_55i_depth_of_a_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

public class sfo_55i_depth_of_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.maxDepth(root);
        System.out.println(res);
    }
}
