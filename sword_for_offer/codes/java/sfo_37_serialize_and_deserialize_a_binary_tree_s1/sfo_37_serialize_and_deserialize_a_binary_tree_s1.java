/*
* File: sfo_37_serialize_and_deserialize_a_binary_tree_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_37_serialize_and_deserialize_a_binary_tree_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Codec {
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

public class sfo_37_serialize_and_deserialize_a_binary_tree_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String data = "[1,2,3,null,null,4,5,null,null,null,null]";
        // ====== Driver Code ======
        Codec codec = new Codec();
        TreeNode root = codec.deserialize(data);
        String res = codec.serialize(root);
        PrintUtil.printTree(root);
        System.out.println(res);
    }
}