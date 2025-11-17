package leetcode;

/**
 * LeetCode Problem 81: Search in Rotated Sorted Array II
 * Difficulty: Medium
 * 
 * <p>Search in rotated sorted array with duplicates.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0081_SearchInRotatedSortedArrayII {
    public static boolean search(int[] arr, int target) {
        int low = 0; int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[mid] <= arr[high]) {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }
}
