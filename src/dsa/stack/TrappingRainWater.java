package dsa.stack;

/**
 * TrappingRainWater
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class TrappingRainWater {
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

    private static int[] getMaxToRight(int[] height) {
        int[] maxToRight = new int[height.length];

        maxToRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxToRight[i] = Math.max(height[i], maxToRight[i + 1]);
        }

        return maxToRight;
    }

    public static void main(String[] args) {
        System.out.println(TrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
