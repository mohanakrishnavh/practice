package dsa.search;

/**
 * BinarySearch
 *
 * <p>Binary search on a <b>sorted (ascending)</b> array: repeatedly compare the target with the middle
 * element and discard the half that cannot contain it.
 *
 * <p><b>Complexity:</b> Time O(log n). Space O(1) for the iterative versions, O(log n) call stack for the recursive one.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinarySearch {
    /**
     * Iteratively searches the whole array for {@code target}.
     *
     * @param arr    array sorted in ascending order
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Search window is [start, end] inclusive; when it becomes empty (start > end) the target is absent
        while (start <= end) {
            // Why `start + (end - start) / 2` instead of `(start + end) / 2`:
            //  - `start + end` can exceed Integer.MAX_VALUE for very large arrays and overflow into a
            //    negative number, producing a negative/invalid index (a classic bug that sat in the JDK's
            //    own binarySearch for years).
            //  - `end - start` is always within int range, and adding it to `start` gives the same midpoint
            //    mathematically, with no overflow risk.
            // Integer division rounds down, so mid is the lower middle for even-sized windows.
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                // Target can only be in the left half; mid is already ruled out, hence mid - 1
                end = mid - 1;
            } else {
                // Target can only be in the right half
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Recursive search over the whole array; convenience wrapper for the range version below.
     *
     * @param arr    array sorted in ascending order
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int searchRecursive(int[] arr, int target) {
        return searchRecursive(arr, 0, arr.length - 1, target);
    }

    /**
     * Recursively searches {@code arr[start..end]} (inclusive) for {@code target}.
     *
     * <p>Each call returns the result of exactly one recursive call, on the half that can still contain the target:
     * {@code [mid + 1, end]} if the target is larger than {@code arr[mid]}, otherwise {@code [start, mid - 1]}.
     *
     * @param arr    array sorted in ascending order
     * @param start  first index of the current window
     * @param end    last index of the current window
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int searchRecursive(int[] arr, int start, int end, int target) {
        // Base case: empty window -> not found
        if (start > end) {
            return -1;
        }

        // Overflow-safe midpoint (see the explanation in search(int[], int))
        int mid = start + (end - start)/2;
        if (arr[mid] == target) {
            return mid;
        }

        if (target > arr[mid]) {
            // Target is larger: only the right half can contain it (the result must be returned)
            return BinarySearch.searchRecursive(arr, mid + 1, end, target);
        }

        // Target is smaller: only the left half of the current window can contain it
        return BinarySearch.searchRecursive(arr, start, mid - 1, target);
    }

    /**
     * Iteratively searches only the sub-range {@code arr[start..end]} (inclusive); useful as a building
     * block when the caller already knows the window (e.g. rotated arrays, search on answer).
     *
     * @param arr    array sorted in ascending order within the given range
     * @param start  first index to consider
     * @param end    last index to consider
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present in the range
     */
    public static int search(int[] arr, int start, int end, int target) {
        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));           // 4
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100));         // -1
        System.out.println(searchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));   // 4
        System.out.println(searchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100)); // -1
    }
}
