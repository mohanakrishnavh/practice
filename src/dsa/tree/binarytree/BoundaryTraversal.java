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
 * @author Practice Repository
 * @version 1.0
 */
public class BoundaryTraversal {
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

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode current = root.left;
        while (current != null) {
            if (!isLeaf(current)) {
                boundary.add(current.val);
            }

            current = current.left != null ? current.left : current.right;
        }
    }

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
