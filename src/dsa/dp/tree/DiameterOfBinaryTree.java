package dsa.dp.tree;

import dsa.tree.TreeNode;

/**
 * DiameterOfBinaryTree
 * 
 * <p>This class calculates the diameter of a binary tree, which is the length of the longest
 * path between any two nodes. The path may or may not pass through the root. The diameter
 * can be measured either as the number of edges or the number of nodes on the path.
 * Uses tree DP where for each node, we calculate the maximum path through it by summing
 * the heights of its left and right subtrees.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DiameterOfBinaryTree {
    /**
     * Calculates the diameter of the binary tree.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(h) where h is the height (recursion stack)
     * 
     * @param root the root of the binary tree
     * @return the number of nodes in the diameter of the tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        height(root, result);

        // returns the numbers of nodes in the diameter of the tree
        return result[0];
    }

    /**
     * Calculates height and updates the maximum diameter.
     * 
     * <p>For each node, the potential diameter through it is:
     * 1 + leftHeight + rightHeight (using nodes)
     * or leftHeight + rightHeight (using edges)
     * 
     * @param root current node
     * @param result array to store the maximum diameter
     * @return height of the tree rooted at this node
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
