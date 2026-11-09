package dsa.search;

/**
 * ReverseBinarySearch
 *
 * <p>Binary search on an array sorted in <b>descending</b> order. It is the mirror image of
 * {@link BinarySearch}: the only difference is that the two "discard a half" branches are swapped.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReverseBinarySearch {
    /**
     * Searches the whole descending-sorted array for {@code target}.
     *
     * @param nums   array sorted in descending order
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // Window [start, end] is inclusive; an empty window (start > end) means the target is absent
        while (start <= end) {
            // Overflow-safe midpoint (avoids `start + end` exceeding Integer.MAX_VALUE)
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                // Descending order: smaller values live to the RIGHT of mid, so search the right half
                start = mid + 1;
            } else {
                // Target is larger than nums[mid], so it must be in the LEFT half (larger values come first)
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Searches only the sub-range {@code nums[startIndex..endIndex]} (inclusive) of a descending-sorted array.
     * Handy as a building block when the caller already knows the window.
     *
     * @param nums       array sorted in descending order within the given range
     * @param startIndex first index to consider
     * @param endIndex   last index to consider
     * @param target     value to find
     * @return index of {@code target}, or -1 if it is not present in the range
     */
    public static int search(int[] nums, int startIndex, int endIndex, int target) {
        // Copy the parameters into locals so the window can shrink without reassigning arguments
        int start = startIndex;
        int end = endIndex;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                // Smaller values are to the right in a descending array
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 9));  // 7
        System.out.println(search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 25)); // -1
    }
}
