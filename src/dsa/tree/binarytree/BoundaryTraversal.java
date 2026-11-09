package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BoundaryTraversal
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BoundaryTraversal {
    /**
     * Returns the boundary anticlockwise: root, left boundary, leaves left to right, then right boundary bottom-up.
     *
     * @param root root of the tree
     * @return boundary values
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }

        if (!isLeaf(root)) {
            boundary.add(root.val);
        }
        addLeftBoundary(root, boundary);
        addLeafNodes(root, boundary);
        addRightBoundary(root, boundary);

        return boundary;
    }

    /**
     * @param root node to test
     * @return {@code true} if the node has no children
     */
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    /**
     * Adds the left boundary top-down, excluding leaves; prefers the left child, else the right.
     *
     * @param root     tree root
     * @param boundary accumulator list
     */
    private void addLeftBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode current = root.left;
        while (current != null) {
            if (!isLeaf(current)) {
                boundary.add(current.val);
            }

            current = current.left != null ? current.left : current.right;
        }
    }

    /**
     * Adds all leaves left to right via DFS.
     *
     * @param root     current node
     * @param boundary accumulator list
     */
    private void addLeafNodes(TreeNode root, List<Integer> boundary) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            boundary.add(root.val);
            return;
        }

        addLeafNodes(root.left, boundary);
        addLeafNodes(root.right, boundary);
    }

    /**
     * Adds the right boundary bottom-up, excluding leaves (collected on a stack, then popped in reverse).
     *
     * @param root     tree root
     * @param boundary accumulator list
     */
    private void addRightBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode current = root.right;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            if (!isLeaf(current)) {
                stack.push(current.val);
            }

            current = current.right != null ? current.right : current.left;
        }

        while(!stack.isEmpty()) {
            boundary.add(stack.pop());
        }
    }

}
