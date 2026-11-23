package leetcode;

/**
 * SearchCircularSortedArray
 * 
 * Searches for a target in a sorted array that has been rotated (circular sorted array).
 *
 * <p>Approach: Modified binary search. At each step one half around {@code mid} is
 * guaranteed to be sorted; check whether the target lies in that half and discard the other.
 *
 * <p>Time Complexity: O(log n). Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SearchCircularSortedArray {
    /**
     * Returns the index of {@code target} in the rotated sorted array.
     *
     * @param nums a rotated sorted array of distinct values
     * @param target the value to find
     * @return the index of the target, or -1 if it is not present
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(SearchCircularSortedArray.search(new int[]{12, 14, 18, 21, 3, 6, 8, 9}, 6));
    }
}
