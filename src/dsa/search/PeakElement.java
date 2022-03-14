package dsa.search;

public class PeakElement {
    public static int getPeakElement(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(getPeakElement(new int[]{5, 10, 20, 15}));
        System.out.println(getPeakElement(new int[]{10, 20, 15, 2, 23, 90, 67}));
        System.out.println(getPeakElement(new int[]{10, 20, 30, 40, 50}));
        System.out.println(getPeakElement(new int[]{50, 40, 30, 20, 10}));
        System.out.println(getPeakElement(new int[]{1}));
        System.out.println(getPeakElement(new int[]{1, 2}));
        System.out.println(getPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}
