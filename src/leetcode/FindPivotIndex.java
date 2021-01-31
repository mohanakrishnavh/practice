package leetcode;

import java.util.Arrays;

public class FindPivotIndex {

    public int getPivotIndex(int[] nums) {
        int leftSum = 0;
        int sum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();
        System.out.println(obj.getPivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
