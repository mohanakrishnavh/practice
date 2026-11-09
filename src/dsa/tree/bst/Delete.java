package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * Delete
 * 
 * Delete Node in a BST (LeetCode 450). Handles three cases: leaf, one child, and two children (replace the value with
 * the inorder successor, then delete the successor).
 *
 * <p><b>Complexity:</b> Time O(h), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Delete {
    /**
     * Deletes {@code key} from the BST: leaf is removed, a single child replaces the node, and with two children the node takes its inorder successor's value.
     *
     * @param root root of the BST
     * @param key  value to delete
     * @return new root of the subtree
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1 : No Children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2 : One Child
            else if (root.left == null) {
                root = root.right;
            }
            else if (root.right == null) {
                root = root.left;
            }

            // Case 3 : Two Children
            else {
                TreeNode node = findMin(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }

        return root;
    }

    /**
     * @param root subtree root
     * @return leftmost (smallest) node, or {@code null} if empty
     */
    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while(current.left != null) {
            current = current.left;
        }

        return current;
    }
}
