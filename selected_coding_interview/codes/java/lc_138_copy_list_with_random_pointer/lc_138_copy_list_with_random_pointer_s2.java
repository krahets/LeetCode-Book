/*
* File: lc_138_copy_list_with_random_pointer_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_138_copy_list_with_random_pointer;

import include.*;
import java.util.*;

// ===== Solution Code =====
    // Definition for a Node.
    class Node {
        int val;
        Node next, random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

public class lc_138_copy_list_with_random_pointer_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Simple linked list with random pointers
        node1 = Node(7)
        node2 = Node(13)
        node3 = Node(11)
        node4 = Node(10)
        node5 = Node(1)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node2.random = node1
        node3.random = node5
        node4.random = node3
        node5.random = node1

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.copyRandomList(node1);
        System.out.println("Copied list head value:" + " " + (result != null ? result.val : null));

    }
}
