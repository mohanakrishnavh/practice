package dsa.search;

/**
 * ReverseBinarySearch
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ReverseBinarySearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int search(int[] nums, int startIndex, int endIndex, int target) {
        int start = startIndex;
        int end = endIndex;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 9));
        System.out.println(search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 25));
    }
}
