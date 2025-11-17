package dsa.search;

/**
 * OrderAgnosticSearch
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class OrderAgnosticSearch {
    public static int search(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length > 0) {
            if (nums[start] == nums[end]) {
                return nums[start] == key ? 0 : -1;
            }

            return nums[start] < nums[end] ? BinarySearch.search(nums, key) : ReverseBinarySearch.search(nums, key);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 12));
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 100));
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, 100));
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, -1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, -1));
    }
}
