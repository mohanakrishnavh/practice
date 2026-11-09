package dsa.tree.binarytree;

import dsa.tree.TreeNode;
import java.util.Stack;

/**
 * FlattenBinaryTreeToLinkedList
 * 
 * Flatten Binary Tree to Linked List (LeetCode 114): rewires the tree in place so each node's right pointer is the
 * next node in preorder and left pointers are null.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h) for the stack.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * Flattens the tree in place into a right-skewed list in preorder, using a stack.
     *
     * @param root root of the tree
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }


            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            current.left = null;
        }
    }

}
