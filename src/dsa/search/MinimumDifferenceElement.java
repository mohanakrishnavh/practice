package dsa.search;

/**
 * MinimumDifferenceElement
 *
 * <p>Finds the element of a sorted (ascending) array that is <b>closest in value</b> to a given key, i.e. the one
 * minimising {@code |element - key|}. Two approaches are shown.
 *
 * <p><b>Key observation:</b> if the key is not in the array, the closest element is either its <i>floor</i> (largest
 * value below the key) or its <i>ceiling</i> (smallest value above it) — the two neighbours the key would sit between.
 *
 * <p><b>Complexity (both):</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MinimumDifferenceElement {
    // Approach 1 : Find the ceil and floor of the element
    // Return whichever of the two is closer to the given element
    /**
     * Approach 1: finds the two neighbours of the key (ceiling and floor) and returns the closer one.
     *
     * <p>The ceiling's index comes from {@link LowerBound#findLowerBound} (first index with {@code nums[i] >= key});
     * the floor, if the key is absent, is the element just before it. Working with <i>indices</i> instead of the
     * values from {@link CeilOfAnElement} / {@link FloorOfAnElement} avoids their {@code -1} "not found" sentinel,
     * which would be ambiguous (and wrong) here.
     *
     * <p>Cases:
     * <ul>
     *   <li>key above every element → the last element is the closest;</li>
     *   <li>key at or below the first element → the first element is the closest (this also covers an exact match at index 0);</li>
     *   <li>otherwise compare {@code |floor - key|} with {@code |ceil - key|}. An exact match has difference 0 and wins;
     *       on a tie the larger element is returned, consistent with the optimized version.</li>
     * </ul>
     *
     * @param nums array sorted in ascending order, non-empty
     * @param key  value to compare against
     * @return the element of {@code nums} closest to {@code key} (ties go to the larger element)
     * @throws IllegalArgumentException if {@code nums} is empty
     */
    public static int getElementWithMinimumDifference(int[] nums, int key) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("nums must not be empty");
        }

        // Index of the ceiling: smallest element >= key (nums.length if there is none)
        int ceilIndex = LowerBound.findLowerBound(nums, key);

        // No ceiling: key is larger than everything, so the last element (the floor) is closest
        if (ceilIndex == nums.length) {
            return nums[nums.length - 1];
        }

        // No floor: key is <= the first element, so the first element (the ceiling) is closest
        if (ceilIndex == 0) {
            return nums[0];
        }

        int ceil = nums[ceilIndex];
        int floor = nums[ceilIndex - 1];

        // Compare distances, not values
        return Math.abs(ceil - key) <= Math.abs(floor - key) ? ceil : floor;
    }

    // Approach 2 : Running the Binary Search
    // Case 1 : Element is present in the array, return the element
    // Case 2 : Element is not present in the array, return the min(abs(arr[start] - key), abs(arr[end] - key))
    /**
     * Approach 2: a single binary search that exploits where the pointers end up.
     *
     * <p>If the key is found, it is its own closest element (difference 0). If the loop ends without a match, the
     * window has collapsed so that {@code end} is the index of the floor and {@code start = end + 1} is the index
     * of the ceiling. The two neighbours are compared by absolute difference and the closer value is returned
     * (on a tie, the larger one, {@code nums[start]}).
     *
     * <p>Edge cases: if the key is larger than every element then {@code start == nums.length} (no ceiling), so the
     * last element is returned; if it is smaller than every element then {@code end == -1} (no floor), so the first
     * element is returned.
     *
     * @param nums array sorted in ascending order, non-empty
     * @param key  value to compare against
     * @return the element closest to {@code key} (ties go to the larger element)
     * @throws IllegalArgumentException if {@code nums} is empty
     */
    public static int getElementWithMinimumDifferenceOptimized(int[] nums, int key) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            // Case 1: exact match -> difference 0, can't do better
            if (nums[mid] == key) {
                return nums[mid];
            }

            if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Key is larger than every element: there is no ceiling, the floor (last element) is the answer
        if (start == nums.length) {
            return nums[end];
        }

        // Key is smaller than every element: there is no floor, the ceiling (first element) is the answer
        if (end < 0) {
            return nums[start];
        }

        // Case 2: no match. Now end = index of floor, start = index of ceiling; pick the closer one
        return Math.abs(nums[start] - key) <= Math.abs(nums[end] - key) ? nums[start] : nums[end];
    }

    public static void main(String[] args) {
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 7));  // 6  (floor 6 is closer than ceil 10)
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 6));  // 6  (exact match)
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 9));  // 10 (ceil is closer, not just the smaller value)
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 20)); // 10 (key above everything)
        System.out.println(getElementWithMinimumDifference(new int[]{4, 6, 10}, 1));  // 4  (key below everything)
        System.out.println(getElementWithMinimumDifferenceOptimized(new int[]{1, 3, 8, 10, 15}, 12));     // 10 (|10-12|=2 < |15-12|=3)
        System.out.println(getElementWithMinimumDifferenceOptimized(new int[]{1, 3, 8, 10, 12, 15}, 12)); // 12 (exact match)
    }
}
