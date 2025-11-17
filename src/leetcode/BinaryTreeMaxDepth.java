package leetcode;

import dsa.tree.TreeNode;

/**
 * Binary Tree Maximum Depth (LeetCode Problem 104)
 * Difficulty: Easy
 * 
 * <p>Given the root of a binary tree, return its maximum depth.
 * 
 * <p>A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * <p>Example 1:
 * <pre>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Explanation: The longest path is 3->20->7 or 3->20->15
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: root = [1,null,2]
 * Output: 2
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the tree is in the range [0, 10^4]</li>
 *   <li>-100 <= Node.val <= 100</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes (visit each node once)
 * <p>Space Complexity: O(h) where h is the height (recursion stack)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BinaryTreeMaxDepth {
    
    /**
     * Calculates the maximum depth of a binary tree.
     * 
     * <p>Algorithm (Recursive DFS):
     * <ol>
     *   <li>If the tree is empty (root is null), depth is 0</li>
     *   <li>If it's a leaf node (no children), depth is 1</li>
     *   <li>Otherwise, depth is 1 + max(leftDepth, rightDepth)</li>
     * </ol>
     * 
     * <p>This implementation uses Integer.MIN_VALUE to handle null children,
     * ensuring that only existing paths contribute to the depth.
     * 
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = root.left == null ? Integer.MIN_VALUE : maxDepth(root.left);
        int rightDepth = root.right == null ? Integer.MIN_VALUE : maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
