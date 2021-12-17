/*
* File: sfo_31_validate_stack_sequences_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_31_validate_stack_sequences_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

public class sfo_31_validate_stack_sequences_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.validateStackSequences(pushed, popped);
        System.out.println(res);
    }
}
