package leetcode;

/**
 * TrappingRainWater
 * 
 * Computes how much rain water is trapped between bars of an elevation map.
 *
 * <p>Approach: The water above bar {@code i} is {@code min(maxLeft[i], maxRight[i]) - height[i]}.
 * Precompute the running maximum from the left and right, then sum the water over all bars.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TrappingRainWater {
    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * Returns the total units of trapped water.
     *
     * @param height the bar heights (must be non-empty)
     * @return the trapped water volume
     */
    public int trap(int[] height) {
        int trappedWater = 0;

        // Compute maxToLeft array
        int[] maxToLeft = new int[height.length];
        maxToLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxToLeft[i] = Math.max(maxToLeft[i - 1], height[i]);
        }

        // Compute maxToRight array
        int[] maxToRight = new int[height.length];
        maxToRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxToRight[i] = Math.max(maxToRight[i + 1], height[i]);
        }

        // Compute trapped water
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(maxToLeft[i], maxToRight[i]) - height[i];
        }

        return trappedWater;
    }
}
