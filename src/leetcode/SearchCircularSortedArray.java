package leetcode;

public class SearchCircularSortedArray {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchCircularSortedArray.search(new int[]{12, 14, 18, 21, 3, 6, 8, 9}, 6));
    }
}