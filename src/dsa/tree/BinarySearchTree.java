package dsa.tree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * BinarySearchTree
 * 
 * <p>Binary search tree of ints built on {@link BinaryTree}: iterative insert, search, ceiling and floor lookups,
 * min/max lookups and printing traversals. Duplicates go to the left subtree. The {@code main} method doubles as a self-checking test suite.
 *
 * <p><b>Complexity:</b> insert, search, ceil, floor, min and max are O(h) where h is the tree height.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinarySearchTree extends BinaryTree {

    /**
     * Creates an empty BST.
     */
    public BinarySearchTree() {
        super();
    }


    /**
     * Searches the subtree rooted at {@code root} for a value, going left or right at each node.
     *
     * @param root root of the (sub)tree to search
     * @param val  value to find
     * @return the node holding {@code val}, or {@code null} if it is not present
     */
    public TreeNode search(TreeNode root, int val) {
        TreeNode current = root;
        while(current != null && current.val != val) {
            current = val < current.val ? current.left : current.right;
        }

        return current;
    }

    /**
     * Finds the ceiling of {@code x}: the smallest value in the tree that is greater than or equal to {@code x}.
     * Each node that is large enough becomes the candidate and the search continues left for a closer one.
     *
     * @param root root of the (sub)tree to search
     * @param x    value to find the ceiling of
     * @return the ceiling, or -1 if every value in the tree is smaller than {@code x}
     */
    public int ceil(TreeNode root, int x) {
        int ceil = -1;
        TreeNode current = root;
        while(current != null) {
            if (current.val == x) {
                ceil = current.val;
                return ceil;
            }

            if (current.val < x) {
                current = current.right;
            } else {
                ceil = current.val;
                current = current.left;
            }
        }

        return ceil;
    }

    /**
     * Finds the floor of {@code x}: the largest value in the tree that is less than or equal to {@code x}.
     *
     * <p>Note: when a node is smaller than {@code x} the search should continue to the right for a closer value,
     * but this implementation continues to the left, so it can return a value smaller than the true floor.
     *
     * @param root root of the (sub)tree to search
     * @param x    value to find the floor of
     * @return the floor, or -1 if every value in the tree is greater than {@code x}
     */
    public int floor(TreeNode root, int x) {
        int floor = -1;
        TreeNode current = root;
        while(current != null) {
            if (current.val == x) {
                floor = current.val;
                return floor;
            }

            if (current.val < x) {
                floor = current.val;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return floor;
    }

    /**
     * Inserts a value iteratively; values less than or equal to a node go left, larger values go right.
     *
     * @param value value to insert
     */
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        // Case 1: Tree is Empty
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode currentNode = root;
        while (true) {
            // Case 2: When the value is smaller than the current node
            if (value <= currentNode.val) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
                // Case 3: When the value is greater than the current node
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * Returns the smallest value (leftmost node).
     *
     * @return minimum value, or -1 if the tree is empty
     */
    public int min() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the leftmost element
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.val;
    }

    /**
     * Returns the node holding the smallest value (leftmost node).
     *
     * @return minimum node, or {@code null} if the tree is empty
     */
    public TreeNode minNode() {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        // Iterate until we find the leftmost element
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    /**
     * Returns the largest value (rightmost node).
     *
     * @return maximum value, or -1 if the tree is empty
     */
    public int max() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the rightmost element
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.val;
    }

    /**
     * Returns the node holding the largest value (rightmost node).
     *
     * @return maximum node, or {@code null} if the tree is empty
     */
    public TreeNode maxNode() {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        // Iterate until we find the rightmost element
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode;
    }

    /**
     * Prints the values level by level (BFS), space separated.
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Level Order Traversal : ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /**
     * Prints the values in preorder (root, left, right).
     */
    public void preOrderTraversal() {
        System.out.print("PreOrder Traversal : ");
        preOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in preorder.
     *
     * @param root current node
     */
    private void preOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversalUtil(root.left);
        preOrderTraversalUtil(root.right);
    }

    /**
     * Prints the values in inorder (left, root, right), i.e. sorted order for a BST.
     */
    public void inOrderTraversal() {
        System.out.print("InOrder Traversal : ");
        inOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in inorder.
     *
     * @param root current node
     */
    private void inOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalUtil(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalUtil(root.right);
    }

    /**
     * Prints the values in postorder (left, right, root).
     */
    public void postOrderTraversal() {
        System.out.print("PostOrder Traversal : ");
        postOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in postorder.
     *
     * @param root current node
     */
    private void postOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversalUtil(root.left);
        postOrderTraversalUtil(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * Runs self-checks for the BST: min/max, the node-returning lookups, all four traversals, and the
     * empty, single-node and duplicate-value cases. Prints PASS/FAIL per check and exits with status 1 if any fail.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        // Sample tree:      15
        //                 /    \
        //               10      20
        //              /  \       \
        //             8    12      25
        BinarySearchTree bst = new BinarySearchTree();
        for (int value : new int[]{15, 10, 20, 25, 8, 12}) {
            bst.insert(value);
        }

        check("min", 8, bst.min());
        check("max", 25, bst.max());
        check("minNode", 8, bst.minNode().val);
        check("maxNode", 25, bst.maxNode().val);
        check("levelOrder", "Level Order Traversal : 15 10 20 8 12 25", capture(bst::levelOrderTraversal));
        check("preOrder", "PreOrder Traversal : 15 10 8 12 20 25", capture(bst::preOrderTraversal));
        check("inOrder is sorted", "InOrder Traversal : 8 10 12 15 20 25", capture(bst::inOrderTraversal));
        check("postOrder", "PostOrder Traversal : 8 12 10 25 20 15", capture(bst::postOrderTraversal));

        // Empty tree
        BinarySearchTree empty = new BinarySearchTree();
        check("empty min", -1, empty.min());
        check("empty max", -1, empty.max());
        check("empty minNode", null, empty.minNode());
        check("empty maxNode", null, empty.maxNode());
        check("empty levelOrder prints nothing", "", capture(empty::levelOrderTraversal));
        check("empty inOrder", "InOrder Traversal :", capture(empty::inOrderTraversal));

        // Single node
        BinarySearchTree single = new BinarySearchTree();
        single.insert(7);
        check("single min", 7, single.min());
        check("single max", 7, single.max());
        check("single preOrder", "PreOrder Traversal : 7", capture(single::preOrderTraversal));

        // Duplicates go to the left subtree
        BinarySearchTree duplicates = new BinarySearchTree();
        for (int value : new int[]{15, 10, 10}) {
            duplicates.insert(value);
        }
        check("duplicates inOrder", "InOrder Traversal : 10 10 15", capture(duplicates::inOrderTraversal));
        check("duplicates preOrder (dup is left child)", "PreOrder Traversal : 15 10 10",
                capture(duplicates::preOrderTraversal));

        // Degenerate (sorted insert) tree
        BinarySearchTree skewed = new BinarySearchTree();
        for (int value : new int[]{1, 2, 3, 4}) {
            skewed.insert(value);
        }
        check("skewed min", 1, skewed.min());
        check("skewed max", 4, skewed.max());
        check("skewed levelOrder", "Level Order Traversal : 1 2 3 4", capture(skewed::levelOrderTraversal));

        System.out.println(failures == 0 ? "All checks passed" : failures + " check(s) failed");
        if (failures > 0) {
            System.exit(1);
        }
    }

    /** Number of failed checks recorded by {@link #check}. */
    private static int failures = 0;

    /**
     * Compares an expected and actual value, printing PASS or FAIL and counting failures.
     *
     * @param name     description of the check
     * @param expected expected value
     * @param actual   actual value
     */
    private static void check(String name, Object expected, Object actual) {
        boolean ok = Objects.equals(expected, actual);
        if (!ok) {
            failures++;
        }
        System.out.println((ok ? "PASS " : "FAIL ") + name + (ok ? "" : " (expected: " + expected + ", actual: " + actual + ")"));
    }

    /**
     * Runs an action while capturing what it prints to standard output.
     *
     * @param action the action to run
     * @return the captured output with surrounding whitespace trimmed
     */
    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString().trim();
    }
}
