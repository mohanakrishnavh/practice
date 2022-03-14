package leetcode;

public class LC0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;

        if (size == 1) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) {
                return nums[0] > nums[1] ? 0 : 1;
            } else if (mid == size - 1) {
                return nums[size - 1] > nums[size - 2] ? size - 1 : size - 2;
            } else {
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }

                if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
