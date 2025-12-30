/*
* File: lc_946_validate_stack_sequences.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_946_validate_stack_sequences;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int num : pushed) {
                stack.push(num); // num 入栈
                while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }

public class lc_946_validate_stack_sequences {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_pushed = new int[]{1, 2, 3, 4, 5};
        int[] test_input_popped = new int[]{4, 5, 3, 2, 1};
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.validateStackSequences(test_input_pushed, test_input_popped);
        System.out.println(result);

    }
}
