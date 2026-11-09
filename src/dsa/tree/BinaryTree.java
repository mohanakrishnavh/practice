package dsa.tree;

import java.util.*;

/**
 * BinaryTree
 * 
 * Binary tree with the classic traversals (preorder, inorder, postorder in iterative and recursive forms, level order),
 * a right-side view and a BST validity check. Extended by {@link BinarySearchTree}.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinaryTree extends Tree {

    /**
     * Creates an empty binary tree.
     */
    public BinaryTree() {
        super();
    }

    /**
     * Returns the height of the tree rooted at {@code root} (an empty tree is -1).
     *
     * <p>Note: the recurrence {@code 1 + height(left) + height(right)} adds the two subtree heights instead of taking
     * their maximum, so it is only correct for degenerate (path-like) trees.
     *
     * @param root root of the (sub)tree
     * @return computed height
     */
    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + height(root.left) + height(root.right);
    }

    /**
     * Iterative preorder (root, left, right) traversal using a stack; pushes right before left so left pops first.
     *
     * @param root root of the tree
     * @return values in preorder
     */
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

    /**
     * Recursive preorder (root, left, right) traversal.
     *
     * @param root root of the tree
     * @return values in preorder
     */
    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        return preorderTraversalRecursive(root, new ArrayList<>());
    }

    /**
     * Recursive helper that appends visited values to {@code visited}.
     *
     * @param root    current node
     * @param visited accumulator list
     * @return {@code visited}
     */
    private static List<Integer> preorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        visited.add(root.val);
        preorderTraversalRecursive(root.left, visited);
        preorderTraversalRecursive(root.right, visited);

        return visited;
    }

    /**
     * Iterative inorder (left, root, right) traversal: go as far left as possible, pop, then move right.
     *
     * @param root root of the tree
     * @return values in inorder
     */
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

    /**
     * Recursive inorder (left, root, right) traversal.
     *
     * @param root root of the tree
     * @return values in inorder
     */
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        return inorderTraversalRecursive(root, new ArrayList<>());
    }

    /**
     * Recursive helper that appends visited values to {@code visited}.
     *
     * @param root    current node
     * @param visited accumulator list
     * @return {@code visited}
     */
    private static List<Integer> inorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        inorderTraversalRecursive(root.left, visited);
        visited.add(root.val);
        inorderTraversalRecursive(root.right, visited);

        return visited;
    }

    /**
     * Iterative postorder (left, right, root) traversal using two stacks: the second stack yields the reverse of (root, right, left).
     *
     * @param root root of the tree
     * @return values in postorder
     */
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

    /**
     * Recursive postorder (left, right, root) traversal.
     *
     * @param root root of the tree
     * @return values in postorder
     */
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        return postorderTraversalRecursive(root, new ArrayList<>());
    }

    /**
     * Recursive helper that appends visited values to {@code visited}.
     *
     * @param root    current node
     * @param visited accumulator list
     * @return {@code visited}
     */
    private static List<Integer> postorderTraversalRecursive(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return visited;
        }

        postorderTraversalRecursive(root.left, visited);
        postorderTraversalRecursive(root.right, visited);
        visited.add(root.val);

        return visited;
    }


    /**
     * Level-order (BFS) traversal, one list per level.
     *
     * @param root root of the tree
     * @return values grouped by level, top to bottom
     */
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

    /**
     * Returns the nodes visible from the right side: the last node of each level.
     *
     * @param root root of the tree
     * @return rightmost value of each level, top to bottom
     */
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

    /**
     * Checks whether this tree is a valid BST.
     *
     * @return {@code true} if every node respects the BST ordering
     */
    public boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Checks that every node lies strictly between the bounds inherited from its ancestors.
     *
     * @param root     current node
     * @param minValue exclusive lower bound
     * @param maxValue exclusive upper bound
     * @return {@code true} if the subtree is a valid BST within the bounds
     */
    private boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        return root.val > minValue && root.val < maxValue && isBSTUtil(root.left, minValue, root.val) && isBSTUtil(root.right, root.val, maxValue);
    }
}
