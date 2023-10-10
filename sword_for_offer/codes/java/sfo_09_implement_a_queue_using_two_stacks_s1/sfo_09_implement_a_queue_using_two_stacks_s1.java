/*
* File: sfo_09_implement_a_queue_using_two_stacks_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_09_implement_a_queue_using_two_stacks_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class CQueue {
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}

public class sfo_09_implement_a_queue_using_two_stacks_s1 {
    public static void main(String[] args) {
        // ====== Driver Code ======
        List<Integer> res = new ArrayList<>();
        CQueue cQueue = new CQueue();
        res.add(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        res.add(cQueue.deleteHead());
        res.add(cQueue.deleteHead());
        System.out.println(Arrays.toString(res.toArray()));
    }
}
