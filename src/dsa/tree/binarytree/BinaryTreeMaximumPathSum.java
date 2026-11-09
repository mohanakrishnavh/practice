package dsa.tree.binarytree;

import dsa.tree.TreeNode;

/**
 * BinaryTreeMaximumPathSum
 * 
 * Binary Tree Maximum Path Sum (LeetCode 124): the maximum sum over any path, which may start and end at any node.
 * Negative branches are dropped and the best bent path through each node updates a global maximum.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Returns the maximum sum of any path in the tree. A path may start and end at any node.
     *
     * @param root root of the tree
     * @return maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int max = maxPathSumHelper(root, result);

        return result[0];
    }

    /**
     * Returns the best downward path sum starting at {@code root}, and updates {@code result[0]} with the best
     * path that bends at {@code root} (left + node + right). Negative branches are dropped.
     *
     * @param root   current node
     * @param result single-element holder for the global maximum
     * @return best downward path sum starting at {@code root}
     */
    private int maxPathSumHelper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        // To deal with negative nodes
        int leftSum = Math.max(maxPathSumHelper(root.left, result), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right, result), 0);

        result[0] = Math.max(result[0], leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
