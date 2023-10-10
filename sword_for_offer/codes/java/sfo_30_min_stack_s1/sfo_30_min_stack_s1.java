/*
* File: sfo_30_min_stack_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_30_min_stack_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class MinStack {
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}

public class sfo_30_min_stack_s1 {
    public static void main(String[] args) {
        // ====== Driver Code ======
        List<Integer> res = new ArrayList<>();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        res.add(minStack.min());
        minStack.pop();
        res.add(minStack.top());
        res.add(minStack.min());
        System.out.println(Arrays.toString(res.toArray()));
    }
}
