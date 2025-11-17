package dsa.tree.binarytree;

import dsa.tree.TreeNode;
import java.util.Stack;

/**
 * FlattenBinaryTreeToLinkedList
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class FlattenBinaryTreeToLinkedList {

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
