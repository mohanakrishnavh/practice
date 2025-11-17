package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 112: Path Sum
 * Difficulty: Easy
 * 
 * <p>Given the root of a binary tree and an integer targetSum, return true if the tree
 * has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * 
 * <p>A leaf is a node with no children.
 * 
 * <p>Example 1:
 * <pre>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is 5->4->11->2.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are no root-to-leaf paths with sum = 5.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the tree is in the range [0, 5000]</li>
 *   <li>-1000 <= Node.val <= 1000</li>
 *   <li>-1000 <= targetSum <= 1000</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes - must visit all nodes in worst case
 * <p>Space Complexity: O(h) where h is the height - recursion stack depth
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0112_PathSum {
    
    /**
     * Determines if there exists a root-to-leaf path with the given target sum.
     * 
     * <p>Algorithm (Recursive DFS):
     * <ol>
     *   <li>Base case: if node is null, return false</li>
     *   <li>If node is a leaf, check if remaining sum equals node's value</li>
     *   <li>Otherwise, recursively check left and right subtrees with reduced sum</li>
     *   <li>Return true if either subtree has a valid path</li>
     * </ol>
     * 
     * @param root      the root of the binary tree
     * @param targetSum the target sum to find
     * @return true if a root-to-leaf path with the target sum exists, false otherwise
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
