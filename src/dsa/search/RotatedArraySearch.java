package dsa.search;

/**
 * RotatedArraySearch
 *
 * <p>Searches an ascending array that has been rotated at an unknown pivot, e.g.
 * {@code [4, 5, 6, 7, 0, 1, 2]}, in O(log n) without first finding the pivot.
 *
 * <p><b>Key fact:</b> after computing {@code mid}, <i>at least one half is always sorted</i>. Identify the
 * sorted half, check whether the target falls inside its value range, and keep that half; otherwise
 * discard it and keep the other half.
 *
 * <ul>
 *   <li>{@link #search}: distinct values (LeetCode 33).</li>
 *   <li>{@link #isPresent}: duplicates allowed (LeetCode 81), which needs one extra case.</li>
 * </ul>
 *
 * <p><b>Complexity:</b> {@code search} Time O(log n); {@code isPresent} O(log n) on average but O(n) in the worst
 * case (e.g. all equal values); Space O(1) for both.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RotatedArraySearch {
    /**
     * Returns the index of {@code target} in a rotated sorted array of <b>distinct</b> values.
     *
     * <p>Which half is sorted?
     * <ul>
     *   <li>{@code arr[mid] <= arr[high]} → the right half [mid..high] is sorted (no pivot inside it).</li>
     *   <li>otherwise → the left half [low..mid] is sorted (the pivot must be on the right).</li>
     * </ul>
     * Then a range check on the sorted half decides which side to keep.
     *
     * @param arr    rotated ascending array of distinct values
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Overflow-safe midpoint
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] <= arr[high]) {
                // Right half is sorted: keep it only if target lies within (arr[mid], arr[high]]
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // Left half is sorted: keep it only if target lies within [arr[low], arr[mid])
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * Checks whether {@code target} exists in a rotated sorted array that <b>may contain duplicates</b>.
     *
     * <p><b>Why duplicates break {@link #search}:</b> if {@code arr[low] == arr[mid] == arr[high]}, comparing
     * values can't tell which half is sorted (e.g. {@code [3, 1, 2, 3, 3, 3]}: the pivot could be on either side).
     * In that case the only safe move is to shrink the window by one from both ends — those end elements are
     * not the target (it isn't {@code arr[mid]}, which equals them) so nothing is lost. This is what makes the
     * worst case O(n).
     *
     * <p>In every other case at least one half is provably sorted and the logic matches {@link #search}.
     * (The {@code >=} in the first range check is equivalent to {@code >} here, because
     * {@code arr[mid] == target} already returned.)
     *
     * <p>Returns a boolean rather than an index since, with duplicates, "the" index is ambiguous.
     *
     * @param arr    rotated ascending array (duplicates allowed)
     * @param target value to find
     * @return {@code true} if {@code target} is present, otherwise {@code false}
     */
    public static boolean isPresent(int[] arr, int target) {
        int low = 0; int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == target) {
                return true;
            }

            // Ambiguous case: all three equal, can't tell which half is sorted -> trim both ends
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[mid] <= arr[high]) {
                // Right half is sorted
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // Left half is sorted
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Unique Elements
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));   // 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 100)); // -1

        // Duplicate Elements
        System.out.println(isPresent(new int[]{3, 1, 2, 3, 3, 3}, 2));    // true
        System.out.println(isPresent(new int[]{3, 1, 2, 3, 3, 3}, 100));  // false
    }
}
