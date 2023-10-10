/*
* File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_35_clone_a_linked_list_with_next_and_random_pointer_s2;

import include.*;
import java.util.*;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// ===== Solution Code =====
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}

public class sfo_35_clone_a_linked_list_with_next_and_random_pointer_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nodesVal = new int[] { 7, 13, 11, 10, 1 };
        Integer[] nodesRandom = new Integer[] { null, 0, 4, 2, 0 };
        // Construct nodes
        List<Node> nodeList = new ArrayList<>();
        for (int val : nodesVal) {
            nodeList.add(new Node(val));
        }
        // Build next reference
        for (int i = 0; i < nodesVal.length - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        // Build random reference
        for (int i = 0; i < nodesVal.length; i++) {
            if (nodesRandom[i] != null)
                nodeList.get(i).random = nodeList.get(nodesRandom[i]);
        }
        // Get the head of the linked list
        Node head = nodeList.get(0);

        // ====== Driver Code ======
        Solution slt = new Solution();
        Node res = slt.copyRandomList(head);
        // Print the copied linked list
        List<Node> nodeListNew = new ArrayList<>();
        while (res != null) {
            nodeListNew.add(res);
            res = res.next;
        }
        Integer[][] printArr = new Integer[nodesVal.length][2];
        for (int i = 0; i < nodeListNew.size(); i++) {
            Node node = nodeListNew.get(i);
            printArr[i][0] = node.val;
            printArr[i][1] = node.random != null ? nodeListNew.indexOf(node.random) : null;
        }
        System.out.println(Arrays.deepToString(printArr));
    }
}
