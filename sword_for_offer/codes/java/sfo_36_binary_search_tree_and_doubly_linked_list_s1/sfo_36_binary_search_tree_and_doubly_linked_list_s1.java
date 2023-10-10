/*
* File: sfo_36_binary_search_tree_and_doubly_linked_list_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_36_binary_search_tree_and_doubly_linked_list_s1;

import include.*;
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
};

// ===== Solution Code =====
class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

public class sfo_36_binary_search_tree_and_doubly_linked_list_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        List<Node> nodeList = new ArrayList<Node>() {{
            add(new Node(1));
            add(new Node(2));
            add(new Node(3));
            add(new Node(4));
            add(new Node(5));
        }};
        nodeList.get(3).left = nodeList.get(1);
        nodeList.get(3).right = nodeList.get(4);
        nodeList.get(1).left = nodeList.get(0);
        nodeList.get(1).right = nodeList.get(2);
        Node root = nodeList.get(3);

        // ====== Driver Code ======
        Solution slt = new Solution();
        Node res = slt.treeToDoublyList(root);
        // Print the Doubly circular linked list
        List<String> nodesVal = new ArrayList<>();
        for (int i = 0; i <= nodeList.size(); i++) {
            nodesVal.add(String.valueOf(res.val));
            res = res.right;
        }
        System.out.println(String.join(" <-> ", nodesVal));
    }
}
