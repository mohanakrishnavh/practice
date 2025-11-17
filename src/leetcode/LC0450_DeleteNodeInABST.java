package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 450: Delete Node in a BST
 * Difficulty: Medium
 * 
 * <p>Delete a node in a binary search tree.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1 : No Children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2 : One Child
            else if (root.left == null) {
                root = root.right;
            }
            else if (root.right == null) {
                root = root.left;
            }

            // Case 3 : Two Children
            else {
                TreeNode node = findMin(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while(current.left != null) {
            current = current.left;
        }

        return current;
    }
}
