package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (uniqueNums.contains(nums[i])) {
                return true;
            }

            uniqueNums.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[]{1, 2, 3, 4}));
        System.out.println(hasDuplicates(new int[]{1, 2, 2, 4}));
        System.out.println(hasDuplicates(new int[]{}));
    }
}
