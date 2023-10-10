/*
* File: sfo_33_postorder_traversal_of_a_binary_search_tree_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_33_postorder_traversal_of_a_binary_search_tree_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}

public class sfo_33_postorder_traversal_of_a_binary_search_tree_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] postorder = { 1, 6, 3, 2, 5 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.verifyPostorder(postorder);
        System.out.println(res);
    }
}
