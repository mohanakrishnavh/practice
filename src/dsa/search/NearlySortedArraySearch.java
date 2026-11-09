package dsa.search;

/**
 * NearlySortedArraySearch
 *
 * <p>Searches a "nearly sorted" array in O(log n). Here that means an ascending array in which every element
 * may have been moved by at most one position: the element that belongs at index {@code i} is currently at
 * {@code i - 1}, {@code i} or {@code i + 1}. Example: {@code [5, 10, 30, 20, 40]} (30 and 20 were swapped).
 *
 * <p><b>Idea:</b> ordinary binary search breaks because {@code nums[mid]} may not be in its sorted position.
 * But it can be off by at most one, so check {@code mid - 1}, {@code mid} and {@code mid + 1} for the target
 * directly, and only then use the "compare with {@code nums[mid]} and halve" step. The comparison is still
 * valid because the three checked positions cover every spot the displaced neighbours could occupy, so the
 * discarded half cannot contain the target. Since those three positions are already ruled out, the halving
 * skips them too: the window continues at {@code mid - 2} (left) or {@code mid + 2} (right) rather than
 * {@code mid - 1} / {@code mid + 1} as a standard binary search would.
 *
 * <p><b>Complexity:</b> Time O(log n) (three comparisons per step instead of one), Space O(1).
 *
 * <p><b>NOTE:</b> assumes distinct values and the "at most one position away" guarantee; with larger
 * displacements or duplicates the discard step is no longer safe.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NearlySortedArraySearch {
    /**
     * Returns the index of {@code target} in a nearly sorted array.
     *
     * @param nums nearly sorted array: ascending order, each element at most one position from its sorted spot
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // The target may be one slot to the left of mid; the bounds check keeps us inside the window
            if (mid - 1 >= start && nums[mid - 1] == target) {
                return mid - 1;
            }

            // ...or one slot to the right of mid
            if (mid + 1 <= end && nums[mid + 1] == target) {
                return mid + 1;
            }

            // mid-1, mid and mid+1 are all ruled out, so the window can shrink by one extra slot on the
            // side we keep: continue from mid-2 on the left, or from mid+2 on the right
            if (target < nums[mid]) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 10, 30, 20, 40}, 20)); // 3 (found one slot from where binary search would look)
    }
}
