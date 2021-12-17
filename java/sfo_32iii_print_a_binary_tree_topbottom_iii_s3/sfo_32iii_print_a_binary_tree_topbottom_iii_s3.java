/*
* File: sfo_32iii_print_a_binary_tree_topbottom_iii_s3.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_32iii_print_a_binary_tree_topbottom_iii_s3;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}

public class sfo_32iii_print_a_binary_tree_topbottom_iii_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        List<List<Integer>> res = slt.levelOrder(root);
        System.out.println(Arrays.deepToString(res.toArray()));;
    }
}
