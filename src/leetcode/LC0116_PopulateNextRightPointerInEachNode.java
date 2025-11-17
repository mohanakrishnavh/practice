package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 116: Populating Next Right Pointers in Each Node
 * Difficulty: Medium
 * 
 * <p>Populate each next pointer to point to its next right node.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0116_PopulateNextRightPointerInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node current = q.poll();
                if (size > 1) {
                    current.next = q.peek();
                }

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }

                size--;
            }
        }

        return root;
    }

    static class Node {
        int value;
        Node left;
        Node next;
        Node right;
    }
}
