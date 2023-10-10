/*
* File: sfo_26_substructure_of_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_26_substructure_of_a_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

public class sfo_26_substructure_of_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        TreeNode A = TreeNode.arrToTree(new Integer[] { 3, 4, 5, 1, 2, null, null, null, null, null, null });
        TreeNode B = TreeNode.arrToTree(new Integer[] { 4, 1, null, null, null });
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isSubStructure(A, B);
        System.out.println(res);
    }
}
