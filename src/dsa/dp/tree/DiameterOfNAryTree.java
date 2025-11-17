package dsa.dp.tree;

import dsa.tree.Node;
import dsa.util.MathUtil;

/**
 * DiameterOfNAryTree
 * 
 * <p>This class calculates the diameter of an N-ary tree, which is the length of the longest
 * path between any two nodes. Unlike binary trees, each node can have multiple children.
 * The diameter through a node is determined by the two largest heights among its children.
 * Uses tree DP where we find the two maximum heights from all children and sum them to get
 * the potential diameter through each node.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DiameterOfNAryTree {
    /**
     * Calculates the diameter of the N-ary tree.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(h) where h is the height (recursion stack)
     * 
     * @param root the root of the N-ary tree
     * @return the diameter (number of edges in the longest path)
     */
    public int diameter(Node root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        height(root, result);

        return result[0] - 1;
    }

    /**
     * Calculates height and updates the maximum diameter for N-ary tree.
     * 
     * <p>For each node:
     * 1. Calculate heights of all children
     * 2. Find the two maximum heights
     * 3. Diameter through this node = 1 + maxHeight1 + maxHeight2
     * 4. Return 1 + max of all child heights
     * 
     * @param root current node
     * @param result array to store the maximum diameter
     * @return height of the tree rooted at this node
     */
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
