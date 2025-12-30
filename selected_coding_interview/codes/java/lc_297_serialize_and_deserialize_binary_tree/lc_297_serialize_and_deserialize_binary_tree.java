/*
* File: lc_297_serialize_and_deserialize_binary_tree.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_297_serialize_and_deserialize_binary_tree;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
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
            if (data.equals("[]")) return null;
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if (!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    }

public class lc_297_serialize_and_deserialize_binary_tree {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1: Basic binary tree
        TreeNode root = TreeNode.arrToTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        // ====== Driver Code ======
        Codec codec = new Codec();
        var serialized = codec.serialize(root);
        System.out.println("Serialized:" + " " + serialized);
        var deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized root value:" + " " + (deserialized != null ? deserialized.val : null));

    }
}
