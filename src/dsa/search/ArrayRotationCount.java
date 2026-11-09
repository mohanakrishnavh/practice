package dsa.search;

/**
 * ArrayRotationCount
 *
 * <p>Works on an ascending array of <b>distinct</b> values that has been rotated to the right some number of
 * times, e.g. {@code [2, 5, 6, 8, 10, 11, 12, 15, 18]} rotated 5 times is {@code [10, 11, 12, 15, 18, 2, 5, 6, 8]}.
 *
 * <p><b>Key fact:</b> the number of rotations equals the <b>index of the minimum element</b>, because the
 * minimum started at index 0 and every rotation moves it one step right.
 *
 * <p>Both methods find the minimum with a modified binary search by deciding which half is still sorted and
 * where the "break" (the minimum) must therefore lie. Time O(log n), Space O(1).
 *
 * <p><b>NOTE:</b> neither method is safe with duplicate values. For example, {@code findMin} on
 * {@code [2, 2, 2, 0, 2]} sees {@code nums[start] <= nums[end]} immediately and returns 0, which is wrong.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ArrayRotationCount {
    /**
     * Returns the index of the minimum element, i.e. the number of times the array was rotated.
     *
     * <p>Each iteration:
     * <ol>
     *   <li>If the current window is already sorted ({@code nums[start] <= nums[end]}), its minimum is at
     *       {@code start} (this also covers an unrotated array, returning 0).</li>
     *   <li>Otherwise check whether {@code mid} is the minimum: it is smaller than both neighbours. The
     *       modulo arithmetic wraps around so {@code mid = 0} or {@code mid = N - 1} still have a valid
     *       neighbour on the other end.</li>
     *   <li>Otherwise discard the sorted half: if the left part is sorted ({@code nums[start] <= nums[mid]})
     *       the minimum must be on the right, else it is on the left.</li>
     * </ol>
     *
     * @param nums rotated ascending array of distinct values
     * @return index of the minimum (= rotation count), or -1 for an empty array
     */
    private static int findMin(int[] nums) {
        int N = nums.length;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            // Window is already in order -> its smallest value is at the left edge
            if (nums[start] <= nums[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            // Circular neighbours; `+ N` keeps (mid - 1) non-negative before the modulo
            int next = (mid + 1) % N;
            int prev = (mid + N - 1) % N;

            // Minimum is the only element smaller than both of its neighbours
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                // Left half [start..mid] is sorted, so the minimum is in the right half
                start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                // Right half [mid..end] is sorted, so the minimum is in the left half
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Returns the minimum <i>value</i> (not its index) of a rotated sorted array.
     *
     * <p><b>Idea:</b> in any window, one half is always sorted, and the minimum of a sorted half is its first
     * element. So each step records that half's minimum into {@code min} and discards the half, narrowing
     * toward the half that holds the break:
     * <ul>
     *   <li>{@code nums[mid] <= nums[high]}: the right half [mid..high] is sorted, its smallest is
     *       {@code nums[mid]}; record it and move left.</li>
     *   <li>otherwise the left half [low..mid] is sorted, its smallest is {@code nums[low]}; record it and move right.</li>
     * </ul>
     * Unlike {@link #findMin}, it never needs neighbour checks. To get the rotation count from this, you would
     * need the index instead of the value.
     *
     * @param nums rotated ascending array of distinct values
     * @return the minimum value, or {@code Integer.MAX_VALUE} for an empty array
     */
    public int findMin2(int[] nums) {
        int low = 0, high = nums.length - 1;
        // Smallest value seen across the halves we have discarded
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            // Overflow-safe midpoint
            int mid = low + (high - low)/2;

            if (nums[mid] <= nums[high]) {
                // Right half is sorted: nums[mid] is its minimum
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                high = mid - 1;
            } else {
                // Left half is sorted: nums[low] is its minimum
                if (nums[low] < min) {
                    min = nums[low];
                }
                low = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{10, 11, 12, 15, 18, 2, 5, 6, 8})); // 5 (rotated 5 times)
    }
}
