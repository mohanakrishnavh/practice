package leetcode;

public class LC0852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if (nums[mid] < nums[mid+1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return mid;
    }
}
