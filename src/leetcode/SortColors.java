package leetcode;

/**
 * SortColors
 * 
 * Sorts an array of 0s, 1s and 2s in place (Dutch National Flag problem).
 *
 * <p>Approach: Three pointers - {@code low} marks the end of the 0s region, {@code high} the
 * start of the 2s region and {@code medium} scans the unknown middle, swapping values into the
 * correct region.
 *
 * <p>Time Complexity: O(n) single pass. Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SortColors {
    /**
     * Sorts {@code nums} in place so all 0s come first, then 1s, then 2s.
     *
     * @param nums an array containing only 0, 1 and 2
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int medium = 0;
        int high = nums.length - 1;

        while (medium <= high) {
            if (nums[medium] == 0) {
                swap(nums, low, medium);
                low++;
                medium++;
            } else if (nums[medium] == 1) {
                medium++;
            } else if (nums[medium] == 2) {
                swap(nums, medium, high);
                high--;
            }
        }
    }

    /**
     * Swaps the elements at indices {@code i} and {@code j}.
     *
     * @param nums the array
     * @param i the first index
     * @param j the second index
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
