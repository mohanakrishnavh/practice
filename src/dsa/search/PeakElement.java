package dsa.search;

/**
 * PeakElement
 *
 * <p>Finds a <b>peak</b> in an array: an element strictly greater than its neighbours (the ends count as having a
 * {@code -infinity} neighbour outside the array). The array need not be sorted, and any one peak is acceptable
 * (LeetCode 162). Adjacent elements are assumed to be different.
 *
 * <p><b>Key fact:</b> binary search works on an unsorted array because of the slope argument. If
 * {@code arr[mid - 1] < arr[mid]} we are on an uphill slope; walking right either reaches a peak or reaches the end
 * (which counts as a peak), so a peak must exist on the right. Symmetrically, on a downhill slope a peak must exist
 * on the left.
 *
 * <p><b>Idea:</b> compare {@code nums[mid]} with its <i>right</i> neighbour only:
 * <ul>
 *   <li>{@code nums[mid] < nums[mid + 1]} → uphill, so a peak lies to the right of {@code mid}.</li>
 *   <li>otherwise → downhill (or at the top), so {@code mid} itself or something to its left is a peak
 *       (hence {@code end = mid}, keeping {@code mid} in the window).</li>
 * </ul>
 * The window shrinks until {@code start == end}, and that index is a peak. The loop runs while {@code start < end}, so
 * {@code mid < end} and {@code mid + 1} is always a valid index: no special cases for a single element or for peaks at the
 * ends are needed.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PeakElement {
    /**
     * Returns the index of a peak element.
     *
     * @param nums non-empty array with different adjacent elements
     * @return index of a peak element
     */
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            // Overflow-safe midpoint; mid < end, so mid + 1 is in range
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Uphill: a peak exists on the right
                start = mid + 1;
            } else {
                // Downhill: mid or a peak to its left; keep mid in the window
                end = mid;
            }
        }

        // Window collapsed to one index: a peak
        return start;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{5, 10, 20, 15}));                  // 2
        System.out.println(findPeakElement(new int[]{10, 20, 15, 2, 23, 90, 67}));      // 5 (index 1 is also a valid peak; any peak is accepted)
        System.out.println(findPeakElement(new int[]{10, 20, 30, 40, 50}));             // 4 (last element)
        System.out.println(findPeakElement(new int[]{50, 40, 30, 20, 10}));             // 0 (first element)
        System.out.println(findPeakElement(new int[]{1}));                              // 0
        System.out.println(findPeakElement(new int[]{1, 2}));                           // 1
        System.out.println(findPeakElement(new int[]{3, 4, 3, 2, 1}));                  // 1
    }
}
