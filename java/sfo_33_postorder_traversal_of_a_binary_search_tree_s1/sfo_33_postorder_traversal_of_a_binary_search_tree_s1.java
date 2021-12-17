/*
* File: sfo_33_postorder_traversal_of_a_binary_search_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_33_postorder_traversal_of_a_binary_search_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

public class sfo_33_postorder_traversal_of_a_binary_search_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] postorder = { 1, 6, 3, 2, 5 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.verifyPostorder(postorder);
        System.out.println(res);
    }
}
