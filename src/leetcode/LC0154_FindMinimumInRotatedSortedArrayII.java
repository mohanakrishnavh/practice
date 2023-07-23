package leetcode;

public class LC0154_FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int low = 0; int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                if (nums[mid] < min) {
                    min = nums[mid];
                }

                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[mid] <= nums[high]) {
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                high = mid - 1;
            } else {
                if (nums[low] < min) {
                    min = nums[low];
                }
                low = mid + 1;
            }
        }

        return min;
    }
}
