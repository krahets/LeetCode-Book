/*
* File: sfo_27_mirror_of_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_27_mirror_of_a_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}

public class sfo_27_mirror_of_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode root = TreeNode.arrToTree(new Integer[] { 4, 2, 7, 1, 3, 6, 9, null, null, null, null, null, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        TreeNode res = slt.mirrorTree(root);
        PrintUtil.printTree(res);
    }
}
