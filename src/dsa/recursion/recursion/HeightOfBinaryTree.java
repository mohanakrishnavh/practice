package dsa.recursion.recursion;

import dsa.tree.TreeNode;

/**
 * HeightOfBinaryTree
 *
 * <p>Computes the height (max depth) of a binary tree, counted in nodes.
 *
 * <p><b>Idea:</b> height(node) = 1 + max(height(left), height(right)), with height(null) = 0.
 * Postorder style — resolve both subtrees first, then combine at the current node.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h) call stack (h = tree height; O(n) for a skewed tree).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class HeightOfBinaryTree {
    public static int height(TreeNode root) {
        // Base case: an empty tree has height 0
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // The taller subtree decides the height; +1 counts the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
