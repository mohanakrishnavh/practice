package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            int firstIndex = -1;
            int lastIndex = -1;
            int delta = q.peek().index;

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                TreeNode node = pair.node;
                // Subtract to avoid overflow
                int index = pair.index - delta;

                if (i == 0) {
                    firstIndex = index;
                }

                if (i == size-1) {
                    lastIndex = index;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2*index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2*index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex- firstIndex + 1);
        }

        return maxWidth;
    }
}
