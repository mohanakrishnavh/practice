package dsa.search;

/**
 * BitonicArrayMaximumElement
 *
 * <p>Finds the peak of a <b>bitonic</b> array — one that strictly increases up to a maximum and then strictly
 * decreases, e.g. {@code [1, 3, 8, 12, 4, 2]} — in O(log n).
 *
 * <p><b>Idea:</b> compare {@code nums[mid]} with its right neighbour to learn which slope {@code mid} is on:
 * <ul>
 *   <li>{@code nums[mid] < nums[mid + 1]} → ascending slope, so the peak is to the right of {@code mid}.</li>
 *   <li>otherwise → descending slope, so {@code mid} itself may be the peak or the peak is to the left
 *       (hence {@code end = mid}, not {@code mid - 1}).</li>
 * </ul>
 * The window shrinks until {@code start == end}, which is the peak. Because the loop runs while {@code start < end},
 * {@code mid + 1} is always a valid index (mid &lt; end), so no neighbour needs a bounds check, and a maximum at either
 * end (a purely increasing or decreasing array) or a single-element array is handled naturally.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>NOTE:</b> assumes the array is bitonic (strictly increasing then strictly decreasing, either part possibly
 * empty) and non-empty.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BitonicArrayMaximumElement {
    /**
     * Returns the <b>index</b> of the maximum element of a bitonic array.
     *
     * @param nums non-empty bitonic array (strictly increasing, then strictly decreasing)
     * @return index of the maximum element
     */
    public static int getMaximumElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Still climbing: the peak is to the right of mid
                start = mid + 1;
            } else {
                // Descending: mid could be the peak or it is further left, so keep mid in the window
                end = mid;
            }
        }

        // Window has collapsed to a single index: the peak
        return start;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumElement(new int[]{0, 1, 0}));      // 1
        System.out.println(getMaximumElement(new int[]{0, 2, 1, 0}));   // 1
        System.out.println(getMaximumElement(new int[]{0, 10, 5, 2}));  // 1
        System.out.println(getMaximumElement(new int[]{1, 2, 3, 4}));   // 3 (maximum at the end)
        System.out.println(getMaximumElement(new int[]{4, 3, 2, 1}));   // 0 (maximum at the start)
    }
}
