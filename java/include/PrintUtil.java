package include;

import java.util.*;

public class PrintUtil {
    /**
     * Print a linked list
     * @param head
     */
    public static void printLinkedList(ListNode head) {
        List<String> list = new ArrayList<>();
        while (head != null) {
            list.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", list));
    }

    /**
     * Print a binary tree (90º counter-clockwise rotated)
     * @param root
     */
    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    /**
     * Print helper for binary tree
     * @param root
     * @param level
     */
    private static void printTreeHelper(TreeNode root, int level) {
        if (root == null)
            return;
        printTreeHelper(root.right, level + 1);
        System.out.println(" ".repeat(4 * level) + "->" + root.val);
        printTreeHelper(root.left, level + 1);
    }
}
