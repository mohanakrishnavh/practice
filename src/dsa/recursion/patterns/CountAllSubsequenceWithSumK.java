package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * CountAllSubsequenceWithSumK
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CountAllSubsequenceWithSumK {
    public static int subsequenceSum(int[] nums, int k) {
        return subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    private static int subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            // condition is satisfied
            if (sum == k) {
                //System.out.println(subsequence);
                return 1;
            }

            // condition is not satisfied
            return 0;
        }

        subsequence.add(nums[index]);
        int left = subsequenceSum(nums, k, index+1, subsequence, sum + nums[index]);

        subsequence.remove(subsequence.size() - 1);
        int right = subsequenceSum(nums, k, index+1, subsequence, sum);

        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(subsequenceSum(new int[]{1, 2, 1}, 2));
    }
}
