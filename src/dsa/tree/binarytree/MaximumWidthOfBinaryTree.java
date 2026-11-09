package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MaximumWidthOfBinaryTree
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MaximumWidthOfBinaryTree {
    /**
     * Pairs a node with its heap-style index within its level.
     */
    static class Pair {
        TreeNode node;
        int index;

        /**
         * Creates a node/index pair.
         *
         * @param node  tree node
         * @param index position index in a complete-tree numbering
         */
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    /**
     * Returns the maximum width: the largest distance (counting nulls between) between the first and last node of a level. Indices are re-based per level to avoid overflow.
     *
     * @param root root of the tree
     * @return maximum width
     */
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
