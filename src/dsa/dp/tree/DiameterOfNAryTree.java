package dsa.dp.tree;

import dsa.tree.Node;
import dsa.util.MathUtil;

public class DiameterOfNAryTree {
    public int diameter(Node root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int h = height(root, result);

        return result[0] - 1;
    }

    private int height(Node root, int[] result) {
        if (root == null) {
            return 0;
        }

        int size = root.children.size();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = height(root.children.get(i), result);
        }

        int[] maxValues = MathUtil.findTwoMaxNumbers(heights);
        result[0] = Math.max(result[0], 1 + maxValues[0] + maxValues[1]);

        return 1 + Math.max(maxValues[0], maxValues[1]);
    }
}
