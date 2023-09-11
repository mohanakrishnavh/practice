package dsa.tree.bst;

import dsa.tree.TreeNode;

public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, int bound, int[] idx) {
        if (idx[0] == preorder.length || preorder[idx[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = bstFromPreorderHelper(preorder, root.val, idx);
        root.right = bstFromPreorderHelper(preorder, bound, idx);

        return root;
    }
}
