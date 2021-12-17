/*
* File: sfo_54_the_kth_largest_node_of_a_binary_search_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_54_the_kth_largest_node_of_a_binary_search_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}

public class sfo_54_the_kth_largest_node_of_a_binary_search_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 1, 4, null, 2, null, null, null, null });
        int k = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.kthLargest(root, k);
        System.out.println(res);
    }
}
