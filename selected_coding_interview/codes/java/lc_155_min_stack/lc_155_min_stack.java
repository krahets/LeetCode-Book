/*
* File: lc_155_min_stack.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_155_min_stack;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }

public class lc_155_min_stack {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        //operations = ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
        //values = [[], [-2], [0], [-3], [], [], [], []]

        // ====== Driver Code ======
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Min:" + " " + obj.getMin());
        obj.pop();
        System.out.println("Top:" + " " + obj.top());
        System.out.println("Min:" + " " + obj.getMin());

    }
}
