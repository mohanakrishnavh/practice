package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

public class PrintAnySubsequenceWithSumK {
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    private static boolean subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            // condition is satisfied
            if (sum == k) {
                System.out.println(subsequence);
                return true;
            }

            // condition is not satisfied
            return false;
        }

        subsequence.add(nums[index]);
        if (subsequenceSum(nums, k, index+1, subsequence, sum + nums[index])) {
            return true;
        }

        subsequence.remove(subsequence.size() - 1);
        if (subsequenceSum(nums, k, index+1, subsequence, sum)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        subsequenceSum(new int[]{1, 2, 1}, 2);
    }
}
