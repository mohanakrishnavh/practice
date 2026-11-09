package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ZigzagLevelOrderTraversal
 * 
 * Binary Tree Zigzag Level Order Traversal (LeetCode 103): level order where direction alternates every level,
 * implemented by adding to the front or back of each level's list.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ZigzagLevelOrderTraversal {
    /**
     * Level-order traversal that alternates direction each level (left-to-right, then right-to-left).
     *
     * @param root root of the tree
     * @return values grouped by level in zigzag order
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isRightToLeft = false;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }

                if (isRightToLeft) {
                    row.addFirst(node.val);
                } else {
                    row.addLast(node.val);
                }
            }

            isRightToLeft = !isRightToLeft;
            traversal.add(row);
        }

        return traversal;
    }
}
