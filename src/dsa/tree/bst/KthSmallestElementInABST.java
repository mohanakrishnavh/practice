package dsa.tree.bst;

import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * KthSmallestElementInABST
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KthSmallestElementInABST {
    /**
     * Returns the k-th smallest value using an iterative inorder traversal.
     *
     * @param root root of the BST
     * @param k    1-based rank
     * @return the k-th smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }
    }
}
