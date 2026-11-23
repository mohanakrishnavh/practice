package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ContainsDuplicatesII
 * 
 * Checks whether an array contains two equal values at most {@code k} indices apart.
 *
 * <p>Problem: Given an integer array and {@code k}, return true if there are two distinct
 * indices {@code i} and {@code j} with {@code nums[i] == nums[j]} and {@code |i - j| <= k}.
 *
 * <p>Approach: Scan left to right keeping a map of value to its most recent index; on each
 * element, check whether the previous occurrence is within {@code k}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ContainsDuplicatesII {
    /**
     * Returns whether two equal elements exist within distance {@code k}.
     *
     * @param nums the input array (must be non-empty)
     * @param k the maximum allowed index distance
     * @return true if such a pair exists, false otherwise
     */
    public static boolean containsNearbyDuplicates(int[] nums, int k) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        valueIndexMap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i]) && Math.abs(i - valueIndexMap.get(nums[i])) <= k) {
                return true;
            }

            valueIndexMap.put(nums[i], i);
        }

        return false;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicates(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicates(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicates(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}
