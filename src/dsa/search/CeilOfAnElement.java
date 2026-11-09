package dsa.search;

/**
 * CeilOfAnElement
 *
 * <p>Finds the <b>ceiling</b> of a value in a sorted (ascending) array: the smallest element that is
 * greater than or equal to the target. Example: in {@code [1, 2, 3, 4, 8, 10, ...]} the ceiling of 5 is 8.
 *
 * <p><b>Idea:</b> mirror image of {@link FloorOfAnElement}. If {@code nums[mid] > target} it is a valid candidate,
 * but a smaller one may exist to the left, so record it and move left. If {@code nums[mid] < target} it is too small,
 * so move right. An exact match is the best possible answer and returns immediately.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>NOTE:</b> -1 is the "no ceiling" sentinel, so it is ambiguous when the array can contain -1 (negative numbers).
 * The method returns the ceiling <i>value</i>; {@link LowerBound} returns its <i>index</i> without that ambiguity.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CeilOfAnElement {
    /**
     * Returns the ceiling of {@code target}: the smallest array value that is {@code >= target}.
     *
     * @param nums   array sorted in ascending order
     * @param target value whose ceiling is wanted
     * @return the ceiling <i>value</i> (not its index), or -1 if every element is smaller than {@code target}
     */
    public static int getCeil(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // Best candidate so far; -1 means "no element >= target found yet"
        int ceil = -1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            // Exact match: can't get closer from above
            if (nums[mid] == target) {
                return nums[mid];
            }

            if (nums[mid] < target) {
                // Too small to be the ceiling, so look right
                start = mid + 1;
            } else {
                // Valid candidate; a smaller valid one may be on the left, so record and keep looking left
                ceil = nums[mid];
                end = mid - 1;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(getCeil(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5)); // 8 (smallest value >= 5)
        System.out.println(getCeil(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 4)); // 4 (exact match)
    }
}
