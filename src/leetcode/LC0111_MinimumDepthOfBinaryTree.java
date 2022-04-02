package leetcode;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode current = q.poll();

                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }

                size--;
            }

            depth++;
        }
        return -1;
    }
}
