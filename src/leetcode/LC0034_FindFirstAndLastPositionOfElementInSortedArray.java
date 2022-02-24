package leetcode;

public class LC0034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = getFirstIndex(nums, target);
        int lastIndex = -1;
        if (firstIndex != -1) {
            lastIndex = getLastIndex(nums, target);
        }

        return new int[]{firstIndex, lastIndex};
    }

    public int getFirstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                index = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public int getLastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                index = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }
}
