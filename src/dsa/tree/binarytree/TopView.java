package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * TopView
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class TopView {
    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        Map<Integer, Integer> nodeColumnMap = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int column = pair.column;

                nodeColumnMap.computeIfAbsent(column, k -> node.val);

                if (column < minCol) {
                    minCol = column;
                }
                if (column > maxCol) {
                    maxCol = column;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, column - 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, column + 1));
                }
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            Integer val = nodeColumnMap.get(i);

            if (val != null) {
                result.add(val);
            }
        }

        return result;
    }

    static class Pair {
        TreeNode node;
        int column;

        public Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
}
