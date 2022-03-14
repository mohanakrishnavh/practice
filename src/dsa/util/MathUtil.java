package dsa.util;

public class MathUtil {
    public static int max(int[] nums) {
        int maximum = nums[0];
        for (int i=1; i<nums.length; i++) {
            maximum = Math.max(maximum, nums[i]);
        }

        return maximum;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
