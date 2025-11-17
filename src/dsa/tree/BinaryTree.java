package dsa.tree;

import java.util.*;

/**
 * BinaryTree
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BinaryTree extends Tree {

    public BinaryTree() {
        super();
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + height(root.left) + height(root.right);
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
            visited.add(treeNode.val);

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

        visited.add(root.val);
        preorderTraversalRecursive(root.left, visited);
        preorderTraversalRecursive(root.right, visited);

        return visited;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            traversal.add(current.val);
            current = current.right;
        }

        return traversal;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        return inorderTraversalRecursive(root, new ArrayList<>());
    }

    private static List<Integer> inorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        inorderTraversalRecursive(root.left, visited);
        visited.add(root.val);
        inorderTraversalRecursive(root.right, visited);

        return visited;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        if (root == null) {
            return visited;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.empty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);

            if (treeNode.left != null) {
                stack1.push(treeNode.left);
            }

            if (treeNode.right != null) {
                stack1.push(treeNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            visited.add(stack2.pop().val);
        }

        return visited;
    }

    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        return postorderTraversalRecursive(root, new ArrayList<>());
    }

    private static List<Integer> postorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        postorderTraversalRecursive(root.left, visited);
        postorderTraversalRecursive(root.right, visited);
        visited.add(root.val);

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
                level.add(current.val);

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
                    visited.add(current.val);
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

        return root.val > minValue && root.val < maxValue && isBSTUtil(root.left, minValue, root.val) && isBSTUtil(root.right, root.val, maxValue);
    }
}
