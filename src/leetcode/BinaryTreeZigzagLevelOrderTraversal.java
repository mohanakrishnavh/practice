package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();

        if (root == null) {
            return zigzagList;
        }

        boolean isRightToLeft = true;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode top = Q.poll();

                if (isRightToLeft) {
                    row.addLast(top.value);
                } else {
                    row.addFirst(top.value);
                }

                if (top.left != null) {
                    Q.add(top.left);
                }

                if (top.right != null) {
                    Q.add(top.right);
                }
            }

            zigzagList.add(row);
            isRightToLeft = !isRightToLeft;
        }

        return zigzagList;
    }
}
