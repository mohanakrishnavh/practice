package leetcode;

import dsa.tree.Node;

/**
 * LeetCode Problem 1522: Diameter of N-Ary Tree
 * Difficulty: Medium
 * 
 * <p>Find the diameter of an n-ary tree.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC1522_DiameterOfNAryTree {
    public int diameter(Node root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int h = height(root, result);

        return result[0] - 1;
    }

    public int height(Node root, int[] result) {
        if (root == null) {
            return 0;
        }

        int size = root.children.size();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = height(root.children.get(i), result);
        }

        int[] maxValues = findTwoMaxNumbers(heights);
        result[0] = Math.max(result[0], 1 + maxValues[0] + maxValues[1]);

        return 1 + Math.max(maxValues[0], maxValues[1]);
    }

    public int[] findTwoMaxNumbers(int[] array) {
        int maxOne = 0;
        int maxTwo = 0;
        for (int num : array) {
            if (maxOne < num) {
                maxTwo = maxOne;
                maxOne = num;
            } else if (maxTwo < num) {
                maxTwo = num;
            }
        }

        return new int[]{maxOne, maxTwo};
    }
}
