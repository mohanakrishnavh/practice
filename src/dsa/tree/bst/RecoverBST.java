package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * RecoverBST
 * 
 * Recover Binary Search Tree (LeetCode 99): two nodes were swapped by mistake. An inorder traversal of a BST is
 * ascending, so the (at most two) places where it decreases reveal the swapped nodes, whose values are then exchanged.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RecoverBST {

    TreeNode x = null, y = null, prev = null;

    /**
     * Swaps the values of two nodes.
     *
     * @param a first node
     * @param b second node
     */
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    /**
     * Inorder traversal that records the two nodes breaking ascending order ({@code x} first, {@code y} second).
     *
     * @param root current node
     */
    public void findTwoSwapped(TreeNode root) {
        if (root == null) return;
        findTwoSwapped(root.left);
        if (prev != null && root.val < prev.val) {
            y = root;
            if (x == null) x = prev;
            else return;
        }
        prev = root;
        findTwoSwapped(root.right);
    }

    /**
     * Recovers a BST in which exactly two nodes were swapped, by swapping their values back.
     *
     * @param root root of the BST
     */
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    /**
     * Recovers a small sample tree and prints the resulting root value.
     */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);
        System.out.println(root.val);
    }
}
