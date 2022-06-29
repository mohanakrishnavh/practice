package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    static class Pair {
        TreeNode node;
        int column;

        public Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        int minColumnIndex = Integer.MAX_VALUE;
        int maxColumnIndex = Integer.MIN_VALUE;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        Map<Integer, List<Integer>> columnMap = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                int column = pair.column;
                TreeNode node = pair.node;

                columnMap.computeIfAbsent(column, k -> new ArrayList<>());
                columnMap.get(column).add(node.val);
                if (column < minColumnIndex) {
                    minColumnIndex = column;
                }

                if (column > maxColumnIndex) {
                    maxColumnIndex = column;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, column - 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, column + 1));
                }
            }
        }

        for (int i = minColumnIndex; i <= maxColumnIndex; i++) {
            if (columnMap.containsKey(i)) {
                traversal.add(columnMap.get(i));
            }
        }

        return traversal;
    }
}
