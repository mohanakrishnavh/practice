package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 285: Inorder Successor in BST
 * Difficulty: Medium
 * 
 * <p>Find the inorder successor of a given node in a BST.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }

        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root= root.left;
            }
        }

        return successor;
    }
}
