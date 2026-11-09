package dsa.search;

/**
 * BitonicArraySearch
 *
 * <p>Searches for a value in a <b>bitonic</b> array (strictly increasing, then strictly decreasing), e.g.
 * {@code [1, 3, 8, 12, 4, 2]}, in O(log n).
 *
 * <p><b>Idea:</b> split the array at its peak into two sorted pieces and binary-search each with the right
 * orientation:
 * <ol>
 *   <li>Find the peak index with {@link BitonicArrayMaximumElement#getMaximumElement}.</li>
 *   <li>If the peak is the target, done.</li>
 *   <li>Otherwise search the ascending part {@code [0, peak - 1]} with {@link BinarySearch} and the descending part
 *       {@code [peak + 1, n - 1]} with {@link ReverseBinarySearch}.</li>
 * </ol>
 *
 * <p><b>Complexity:</b> Time O(log n) (three binary searches), Space O(1).
 *
 * <p><b>Duplicates across the two sides:</b> the same value can appear once on the ascending side and once on the
 * descending side (e.g. {@code [1, 3, 8, 4, 3]} has a 3 at index 1 and at index 4). When both searches succeed the
 * <i>smaller</i> index is returned, which is always the ascending-side one. Within a single side values are assumed
 * distinct (strictly increasing / strictly decreasing). Either part may be empty (peak at an end); the range searches
 * then return -1 for the empty range.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BitonicArraySearch {
    /**
     * Returns the index of {@code target} in a bitonic array, or -1 if it is absent.
     *
     * @param nums   non-empty bitonic array of distinct values
     * @param target value to find
     * @return index of {@code target} (the smallest index if it occurs on both sides of the peak), or -1 if it is not present
     */
    public static int findInBitonicArray(int[] nums, int target) {
        // Step 1: locate the boundary between the ascending and descending parts
        int max = BitonicArrayMaximumElement.getMaximumElement(nums);

        // The peak itself is neither part, so check it separately
        if (nums[max] == target) {
            return max;
        }

        // Search each side; a miss returns -1 and a hit returns an index >= 0
        int left = BinarySearch.search(nums, 0, max - 1, target);
        int right = ReverseBinarySearch.search(nums, max + 1, nums.length - 1, target);

        // Found on both sides: return the smaller index (the ascending-side match)
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }

        // Found on at most one side: the hit's index (>= 0) beats the miss (-1); both missed gives -1
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 12)); // 3  (the peak)
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 4));  // 4  (descending part)
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 3));  // 1  (ascending part)
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, -1)); // -1 (absent)
        System.out.println(findInBitonicArray(new int[]{1, 3, 8, 4, 3}, 3));      // 1  (on both sides: smaller index)
    }
}
