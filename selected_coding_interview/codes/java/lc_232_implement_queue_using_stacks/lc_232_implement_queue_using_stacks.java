/*
* File: lc_232_implement_queue_using_stacks.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_232_implement_queue_using_stacks;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class MyQueue {
        private Stack<Integer> A;
        private Stack<Integer> B;
        public MyQueue() {
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.push(x);
        }
        public int pop() {
            int peek = peek();
            B.pop();
            return peek;
        }
        public int peek() {
            if (!B.isEmpty()) return B.peek();
            if (A.isEmpty()) return -1;
            while (!A.isEmpty()){
                B.push(A.pop());
            }
            return B.peek();
        }
        public boolean empty() {
            return A.isEmpty() && B.isEmpty();
        }
    }

public class lc_232_implement_queue_using_stacks {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        //operations = ["MyQueue", "push", "push", "peek", "pop", "empty"]
        //values = [[], [1], [2], [], [], []]

        // ====== Driver Code ======
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println("Peek:" + " " + obj.peek());
        System.out.println("Pop:" + " " + obj.pop());
        System.out.println("Empty:" + " " + obj.empty());

    }
}
