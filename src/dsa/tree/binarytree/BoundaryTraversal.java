package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (!isLeaf(root)) {
            boundary.add(root.val);
        }

        addLeftBoundary(root, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root, boundary);

        return boundary;
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

    private void addLeaves(TreeNode root, List<Integer> boundary) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            boundary.add(root.val);
            return;
        }

        addLeaves(root.left, boundary);
        addLeaves(root.right, boundary);
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

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
