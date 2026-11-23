package dsa.stack;

/**
 * TrappingRainWater
 * 
 * Computes how much rain water is trapped between bars of an elevation map (LeetCode 42).
 *
 * <p>Water above a bar is bounded by the shorter of the tallest bars to its left and right:
 * {@code min(maxLeft, maxRight) - height}. The right maxima are precomputed in an array, while the left
 * maximum is tracked while scanning.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TrappingRainWater {
    /**
     * Returns the total trapped water.
     *
     * @param height elevation of each bar
     * @return the units of water trapped
     */
    public static int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int trappedWater = 0;
        int maxToLeft = Integer.MIN_VALUE;
        int[] maxToRight = getMaxToRight(height);
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxToLeft) {
                maxToLeft = height[i];
            }

            trappedWater += Math.min(maxToLeft, maxToRight[i]) - height[i];
        }


        return trappedWater;
    }

    /**
     * Precomputes the running maximum from the right.
     *
     * @param height elevation of each bar
     * @return array where entry i is the maximum height in {@code height[i..n-1]}
     */
    private static int[] getMaxToRight(int[] height) {
        int[] maxToRight = new int[height.length];

        maxToRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxToRight[i] = Math.max(height[i], maxToRight[i + 1]);
        }

        return maxToRight;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(TrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
