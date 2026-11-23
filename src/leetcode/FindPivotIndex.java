package leetcode;

import java.util.Arrays;

/**
 * FindPivotIndex
 * 
 * Finds the pivot index of an array.
 *
 * <p>Problem: The pivot index is the index where the sum of all elements to its left equals
 * the sum of all elements to its right.
 *
 * <p>Approach: Compute the total sum, then scan while tracking the running left sum; the right
 * sum is {@code total - leftSum - nums[i]}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindPivotIndex {

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();
        System.out.println(obj.getPivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * Returns the leftmost pivot index.
     *
     * @param nums the input array
     * @return the pivot index, or -1 if none exists
     */
    public int getPivotIndex(int[] nums) {
        int leftSum = 0;
        int sum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
