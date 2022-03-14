package dsa.search;

import dsa.util.MathUtil;

public class MinimumNumberOfPages {
    public static int getMinimumPages(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        int result = -1;
        int start = MathUtil.max(nums);
        int end = MathUtil.sum(nums);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static boolean isValid(int[] nums, int k, int maximumNumberOfPages) {
        int numberOfStudents = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // If the number of pages allocated to current student exceeds the maximum,
            // we allocate a new student
            if (sum > maximumNumberOfPages) {
                numberOfStudents++;
                sum = num;
            }

            // If the numbers of students needed for current iteration is greater than
            // the given k, then this is an invalid state
            if (numberOfStudents > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 2));
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 5));
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 3));
    }
}
