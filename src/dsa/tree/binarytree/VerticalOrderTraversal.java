package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * VerticalOrderTraversal
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class VerticalOrderTraversal {
    /**
     * Pairs a node with its horizontal column.
     */
    static class Pair {
        TreeNode node;
        int column;

        /**
         * Creates a node/column pair.
         *
         * @param node   tree node
         * @param column horizontal distance from the root (left is negative)
         */
        public Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    /**
     * Groups node values by column, left to right, using BFS so values within a column are top to bottom.
     *
     * @param root root of the tree
     * @return one list per column
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        int columnMin = Integer.MAX_VALUE;
        int columnMax = Integer.MIN_VALUE;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        Map<Integer, List<Integer>> columnPairs = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                int column = pair.column;
                TreeNode node = pair.node;

                columnPairs.computeIfAbsent(column, k -> new ArrayList<>());
                columnPairs.get(column).add(node.val);
                if (column < columnMin) {
                    columnMin = column;
                }

                if (column > columnMax) {
                    columnMax = column;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, column - 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, column + 1));
                }
            }
        }

        for (int i = columnMin; i <= columnMax; i++) {
            if (columnPairs.containsKey(i)) {
                traversal.add(columnPairs.get(i));
            }
        }

        return traversal;
    }
}
