package dsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LargestSubarrayOfSumK
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LargestSubarrayOfSumK {

    // Sliding Window: Only for positive values
    public static int maxSubArrayLen2(int[] nums, int k) {
        int sum = 0, maxLength = 0;
        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];

            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else if (sum > k) {
                while (sum > k && i < nums.length) {
                    sum -= nums[i];
                    i++;
                }
            }
        }

        return maxLength;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int maxLength = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i+1);
            }

            int delta = sum - k;
            if (prefixMap.containsKey(delta)) {
                maxLength = Math.max(maxLength, i - prefixMap.get(delta));
            }

            // [2, 0, 0, 3], K = 3 --> O/P: 3
            // To maximize the window size we know to only store the index of the sum
            // first time it is encountered
            if (!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        int[] nums = new int[]{4, 1, 1, 1, 2, 3, 5};
        System.out.println(maxSubArrayLen(nums, 5));
    }
}
