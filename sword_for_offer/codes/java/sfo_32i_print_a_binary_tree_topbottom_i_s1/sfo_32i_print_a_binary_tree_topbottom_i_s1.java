/*
* File: sfo_32i_print_a_binary_tree_topbottom_i_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_32i_print_a_binary_tree_topbottom_i_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}

public class sfo_32i_print_a_binary_tree_topbottom_i_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.levelOrder(root);
        System.out.println(Arrays.toString(res));
    }
}
