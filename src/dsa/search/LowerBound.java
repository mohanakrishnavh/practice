package dsa.search;

/**
 * LowerBound
 *
 * <p>Lower bound of a value in a sorted (ascending) array: the index of the <b>first element that is
 * greater than or equal to</b> {@code x}. If every element is smaller than {@code x}, the answer is
 * {@code arr.length} (the position where {@code x} would be inserted at the end).
 *
 * <p><b>Idea:</b> binary search that records a candidate whenever {@code arr[mid] >= x} and keeps looking left for
 * an earlier one; otherwise it moves right. This is the same pattern as the first occurrence, but it also works when
 * {@code x} is absent. It matches {@code std::lower_bound} in C++ and is the "insert position" of LeetCode 35.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LowerBound {
    /**
     * Returns the first index {@code i} such that {@code arr[i] >= x}, or {@code arr.length} if none exists.
     *
     * @param arr array sorted in ascending order (duplicates allowed)
     * @param x   value to look for
     * @return the lower-bound index, in the range {@code [0, arr.length]}
     */
    public static int findLowerBound(int []arr, int x) {
        // Write your code here
        int low = 0, high = arr.length - 1;
        // Default: no element is >= x, so the bound is one past the end
        int lowerBound = arr.length;

        while (low <= high) {
            // Overflow-safe midpoint
            int mid = low + (high - low)/2;

            if (arr[mid] >= x) {
                // Valid candidate; an earlier index may also qualify, so record and look left
                lowerBound = mid;
                high = mid - 1;
            } else {
                // arr[mid] < x: the answer must be to the right
                low = mid + 1;
            }
        }

        return lowerBound;
    }

    public static void main(String[] args) {
        System.out.println(findLowerBound(new int[]{1, 2, 2, 3}, 0));         // 0 (everything is >= 0)
        System.out.println(findLowerBound(new int[]{1, 2, 2, 3}, 4));         // 4 (nothing is >= 4 -> length)
        System.out.println(findLowerBound(new int[]{3, 5, 8, 15, 19}, 5));    // 1 (first element >= 5)
    }
}
