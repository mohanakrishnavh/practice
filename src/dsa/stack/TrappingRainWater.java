package dsa.stack;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int trappedWater = 0;

        if (height.length == 0 || height.length == 1) {
            return trappedWater;
        }

        // Compute maxToLeft array
        int[] maxLeftHeight = new int[height.length];
        maxLeftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i]);
        }

        // Compute maxToRight array
        int[] maxRightHeight = new int[height.length];
        maxRightHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i]);
        }

        // Compute trapped water
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        System.out.println(TrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
