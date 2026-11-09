package dsa.search;

/**
 * UpperBound
 *
 * <p>Upper bound of a value in a sorted (ascending) array: the index of the first element that is
 * <b>strictly greater than</b> {@code x}. If no element is greater, the answer is {@code arr.length}.
 *
 * <p><b>Idea:</b> identical to {@link LowerBound} except the comparison is {@code >} instead of {@code >=}, so a
 * run of elements equal to {@code x} is skipped entirely and the result lands just past it. It matches
 * {@code std::upper_bound} in C++.
 *
 * <p><b>Relationship:</b> {@code upperBound(x) - lowerBound(x)} is the number of occurrences of {@code x}, an
 * alternative to the first/last occurrence approach in {@link ElementCount}.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class UpperBound {
    /**
     * Returns the first index {@code i} such that {@code arr[i] > x}, or {@code arr.length} if none exists.
     *
     * @param arr array sorted in ascending order (duplicates allowed)
     * @param x   value to look past
     * @return the upper-bound index, in the range {@code [0, arr.length]}
     */
    public static int findUpperBound(int []arr, int x){
        int low = 0, high = arr.length - 1;
        // Default: no element is > x, so the bound is one past the end
        int upperBound = arr.length;

        while (low <= high) {
            // Overflow-safe midpoint
            int mid = low + (high - low)/2;

            if (arr[mid] > x) {
                // Strictly greater: a candidate, but an earlier one may exist, so record and look left
                high = mid - 1;
                upperBound = mid;
            } else {
                // arr[mid] <= x (equal values are skipped too): the answer is to the right
                low = mid + 1;
            }
        }

        return upperBound;
    }

    public static void main(String[] args) {
        System.out.println(findUpperBound(new int[]{1, 2, 2, 3}, 2));    // 3 (index of 3, just past the 2s)
        System.out.println(findUpperBound(new int[]{1, 2, 2, 3}, 100));  // 4 (nothing greater -> length)
    }
}
