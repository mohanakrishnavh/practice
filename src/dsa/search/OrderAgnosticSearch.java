package dsa.search;

/**
 * OrderAgnosticSearch
 *
 * <p>Binary search on a sorted array when you <b>don't know whether it is ascending or descending</b>.
 *
 * <p><b>Idea:</b> in a sorted array the direction is revealed by comparing the first and last elements.
 * If {@code first < last} the array is ascending, so delegate to {@link BinarySearch}; if {@code first > last}
 * it is descending, so delegate to {@link ReverseBinarySearch}. Deciding the order costs O(1), so the
 * overall cost stays that of a plain binary search.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class OrderAgnosticSearch {
    /**
     * Searches a sorted array of unknown order for {@code key}.
     *
     * <p>Edge cases handled up front:
     * <ul>
     *   <li><b>Empty array</b> → -1.</li>
     *   <li><b>First == last element</b> → in a sorted array this means every element is equal (or there is
     *       only one), so order is meaningless; just check the first element and return 0 or -1.</li>
     * </ul>
     *
     * @param nums sorted array, either ascending or descending
     * @param key  value to find
     * @return index of {@code key}, or -1 if it is not present. With duplicates, any matching index may be returned
     *         (for an all-equal array this method returns 0)
     */
    public static int search(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;

        // Guard against an empty array: nums[start] / nums[end] would be out of bounds
        if (nums.length > 0) {
            // All elements identical (or a single element): no direction to detect
            if (nums[start] == nums[end]) {
                return nums[start] == key ? 0 : -1;
            }

            // Ends differ, so their comparison tells us the sort order
            return nums[start] < nums[end] ? BinarySearch.search(nums, key) : ReverseBinarySearch.search(nums, key);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 12));                // 4  (ascending, found)
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 100));               // -1 (ascending, missing)
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, 100));               // 0  (descending, found)
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, -1));                // -1 (descending, missing)
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, 1));   // 0  (all equal, found)
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, -1));  // -1 (all equal, missing)
    }
}
