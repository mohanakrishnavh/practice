package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }

            uniqueNums.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[]{1, 2, 3, 4}));
        System.out.println(hasDuplicates(new int[]{1, 2, 2, 4}));
        System.out.println(hasDuplicates(new int[]{}));
    }
}
