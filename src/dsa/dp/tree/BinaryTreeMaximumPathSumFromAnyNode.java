package dsa.dp.tree;

import dsa.tree.TreeNode;

/**
 * BinaryTreeMaximumPathSumFromAnyNode
 * 
 * <p>This class finds the maximum path sum in a binary tree where a path can start and end
 * at any node. Similar to BinaryTreeMaximumPathSum but with different handling: it considers
 * the option of taking just the current node's value even if both subtree paths are positive.
 * This is useful when node values can be negative and we want flexibility in path selection.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BinaryTreeMaximumPathSumFromAnyNode {
    /**
     * Finds the maximum path sum in the binary tree.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(h) where h is the height (recursion stack)
     * 
     * @param root the root of the binary tree
     * @return the maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, result);

        return result[0];
    }

    /**
     * Helper method to calculate the maximum path sum with flexibility.
     * 
     * <p>Returns the maximum of:
     * 1. max(leftSum, rightSum) + node.val (extending one subtree path)
     * 2. node.val alone (starting fresh from this node)
     * 
     * This allows the path to "restart" at any node if extending from subtrees
     * would decrease the sum.
     * 
     * @param root current node
     * @param result array to store the global maximum
     * @return maximum sum of a single path starting from this node
     */
    private int maxPathSumHelper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(root.left, result), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right, result), 0);
        result[0] = Math.max(result[0], leftSum + rightSum + root.val);

        return Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
    }
}
