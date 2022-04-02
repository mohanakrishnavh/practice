package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0116_PopulateNextRightPointerInEachNode {
    static class Node {
        int value;
        Node left;
        Node next;
        Node right;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
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
}
