package dsa.tree.binarytree;

import dsa.tree.TreeNode;

/**
 * Diameter
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Diameter {

    /**
     * Returns the diameter: the number of nodes on the longest path between any two nodes.
     *
     * @param root root of the tree
     * @return diameter measured in nodes
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int h = height(root, result);

        // returns the numbers of nodes in the diameter of the tree
        return result[0];
    }

    /**
     * Computes height in nodes while updating {@code result[0]} with the longest path through each node.
     *
     * @param root   current node
     * @param result single-element holder for the best diameter
     * @return height of {@code root}
     */
    private int height(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left, result);
        int rightHeight = height(root.right, result);
        // If the diameter is represented using edges
        // result[0] = Math.max(result[0], leftHeight + rightHeight);
        result[0] = Math.max(result[0], 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
