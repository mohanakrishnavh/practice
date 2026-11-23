package dsa.util;

/**
 * MathUtil
 * 
 * Utility methods for common numeric operations on int arrays.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MathUtil {
    /**
     * Finds the largest value in an array.
     *
     * @param nums a non-empty array
     * @return the maximum value
     * @throws ArrayIndexOutOfBoundsException if the array is empty
     */
    public static int max(int[] nums) {
        int maximum = nums[0];
        for (int i=1; i<nums.length; i++) {
            maximum = Math.max(maximum, nums[i]);
        }

        return maximum;
    }

    /**
     * Computes the sum of all values in an array.
     *
     * @param nums the input array
     * @return the sum (0 for an empty array)
     */
    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    /**
     * Finds the two largest values in an array in a single pass.
     *
     * <p>Note: both maxima start at 0, so arrays containing only negative numbers will report 0 for them.
     *
     * @param nums the input array
     * @return array of {@code {largest, secondLargest}}
     */
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
