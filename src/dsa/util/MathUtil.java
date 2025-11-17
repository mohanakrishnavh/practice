package dsa.util;

/**
 * MathUtil
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
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

    public static int[] findTwoMaxNumbers(int[] nums){
        int maxOne = 0;
        int maxTwo = 0;
        for(int num : nums){
            if(maxOne < num){
                maxTwo = maxOne;
                maxOne =num;
            } else if(maxTwo < num){
                maxTwo = num;
            }
        }

        return new int[]{maxOne, maxTwo};
    }
}
