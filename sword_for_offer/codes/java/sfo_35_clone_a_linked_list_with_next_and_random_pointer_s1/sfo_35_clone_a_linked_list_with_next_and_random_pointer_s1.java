/*
* File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_35_clone_a_linked_list_with_next_and_random_pointer_s1;

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
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
}

public class sfo_35_clone_a_linked_list_with_next_and_random_pointer_s1 {
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
