/*
* File: sfo_59ii_max_queue_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_59ii_max_queue_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}

public class sfo_59ii_max_queue_s1 {
    public static void main(String[] args) {
        // ====== Driver Code ======
        List<Integer> res = new ArrayList<>();
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        res.add(maxQueue.max_value());
        res.add(maxQueue.pop_front());
        res.add(maxQueue.max_value());
        System.out.println(Arrays.toString(res.toArray()));
    }
}
