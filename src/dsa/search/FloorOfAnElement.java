package dsa.search;

/**
 * FloorOfAnElement
 *
 * <p>Finds the <b>floor</b> of a value in a sorted (ascending) array: the greatest element that is
 * less than or equal to the target. Example: in {@code [1, 2, 3, 4, 8, 10, ...]} the floor of 5 is 4.
 *
 * <p><b>Idea:</b> binary search that remembers the best candidate seen so far. Whenever {@code nums[mid] < target},
 * {@code nums[mid]} is a valid floor candidate, but a larger one may exist to the right, so record it and move
 * right. When {@code nums[mid] > target} it is too big, so move left. An exact match is the best possible
 * answer and returns immediately. When the window empties, the last recorded candidate is the floor.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>Related:</b> the ceiling (smallest element &gt;= target) is the mirror image — record the candidate when
 * {@code nums[mid] > target} and move left.
 *
 * <p><b>NOTE:</b> -1 is used as the "no floor" sentinel, so it can't be told apart from a genuine floor of -1
 * if the array contains negative numbers. Returning an index (or {@code Integer.MIN_VALUE}) would avoid the ambiguity.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FloorOfAnElement {
    /**
     * Returns the floor of {@code target}: the largest array value that is {@code <= target}.
     *
     * @param nums   array sorted in ascending order
     * @param target value whose floor is wanted
     * @return the floor <i>value</i> (not its index), or -1 if every element is greater than {@code target}
     */
    public static int getFloor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // Best candidate so far; -1 means "no element <= target found yet"
        int floor = -1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            // Exact match: nothing can be closer to target from below
            if (nums[mid] == target) {
                return nums[mid];
            }

            if (nums[mid] < target) {
                // Valid candidate; a larger valid one may be on the right, so record and keep looking right
                floor = nums[mid];
                start = mid + 1;
            } else {
                // nums[mid] is too large to be the floor, so look left
                end = mid - 1;
            }
        }

        return floor;
    }

    public static void main(String[] args) {
        System.out.println(getFloor(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5)); // 4 (largest value <= 5)
        System.out.println(getFloor(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 4)); // 4 (exact match)
    }
}
