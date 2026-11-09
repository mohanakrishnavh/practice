package dsa.tree.bst;

import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * BinarySearchTreeIterator
 * 
 * BST Iterator (LeetCode 173): iterates a BST in ascending order, holding only the current left spine on a stack.
 *
 * <p><b>Complexity:</b> {@code next} is amortised O(1), {@code hasNext} is O(1), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    /**
     * Creates an iterator over the BST in ascending order; pushes the leftmost path onto a stack.
     *
     * @param root root of the BST
     */
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        addElements(root);
    }

    /**
     * Returns the next smallest value.
     *
     * @return next value in inorder
     */
    public int next() {
        TreeNode node = stack.pop();
        addElements(node.right);

        return node.val;
    }

    /**
     * @return {@code true} if more values remain
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Pushes {@code root} and its chain of left children onto the stack.
     *
     * @param root subtree root
     */
    private void addElements(TreeNode root) {
        TreeNode current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
    }
}
