/*
* File: sfo_34_all_xsum_paths_in_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_34_all_xsum_paths_in_a_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}

public class sfo_34_all_xsum_paths_in_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1, null, null, null, null, null, null, null, null });
        int sum = 22;
        // ====== Driver Code ======
        Solution slt = new Solution();
        List<List<Integer>> res = slt.pathSum(root, sum);
        System.out.println(Arrays.deepToString(res.toArray()));;
    }
}
