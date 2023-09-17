package dsa.tree.bst;

import dsa.tree.TreeNode;

public class RecoverBST {

    TreeNode x = null, y = null, prev = null;

    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

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

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);
        System.out.println(root.val);
    }
}
