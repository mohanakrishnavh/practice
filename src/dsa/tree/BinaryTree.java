package dsa.tree;

import java.util.*;

public class BinaryTree extends Tree {

    public BinaryTree() {
        super();
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        if (root == null) {
            return visited;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            visited.add(treeNode.value);

            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
        }

        return visited;
    }

    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        return preorderTraversalRecursive(root, new ArrayList<>());
    }

    private static List<Integer> preorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        visited.add(root.value);
        preorderTraversalRecursive(root.left, visited);
        preorderTraversalRecursive(root.right, visited);

        return visited;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        if (root == null) {
            return visited;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            visited.add(current.value);
            current = current.right;
        }

        return visited;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        return inorderTraversalRecursive(root, new ArrayList<>());
    }

    private static List<Integer> inorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        inorderTraversalRecursive(root.left, visited);
        visited.add(root.value);
        inorderTraversalRecursive(root.right, visited);

        return visited;
    }


    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<>();
        if (root == null) {
            return visited;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int length = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode current = q.poll();
                level.add(current.value);

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            visited.add(level);
        }

        return visited;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        if (root == null) {
            return visited;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int length = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode current = q.poll();

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }

                if (i == length - 1) {
                    visited.add(current.value);
                }
            }
        }

        return visited;
    }

    public boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        return root.value > minValue && root.value < maxValue && isBSTUtil(root.left, minValue, root.value) && isBSTUtil(root.right, root.value, maxValue);
    }
}
