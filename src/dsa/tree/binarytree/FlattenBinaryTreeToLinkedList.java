package dsa.tree.binarytree;

import dsa.tree.TreeNode;
import java.util.Stack;

/**
 * FlattenBinaryTreeToLinkedList
 * 
 * <p>TODO: Add class description
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
