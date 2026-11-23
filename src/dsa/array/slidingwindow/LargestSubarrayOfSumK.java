package dsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LargestSubarrayOfSumK
 * 
 * Finds the length of the longest subarray whose elements sum to {@code k}.
 *
 * <p>Two approaches are provided: a sliding window ({@link #maxSubArrayLen2}), valid only when all
 * values are positive, and a prefix-sum hash map ({@link #maxSubArrayLen}) that also works with
 * negative values and zeros.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LargestSubarrayOfSumK {

    /**
     * Sliding-window attempt; only valid for arrays of positive values because the window
     * is shrunk whenever the running sum exceeds {@code k}.
     *
     * <p>Note: {@code j} is never advanced in this method, so it does not terminate on most
     * inputs. Use {@link #maxSubArrayLen} instead.
     *
     * @param nums array of positive integers
     * @param k    target sum
     * @return length of the longest subarray summing to {@code k}
     */
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

    /**
     * Finds the longest subarray with sum {@code k} using prefix sums.
     *
     * <p>For a running sum {@code s}, a subarray ending here sums to {@code k} if {@code s - k} was
     * seen earlier. Only the first index of each prefix sum is stored so the window is as long as possible.
     *
     * <p>Time complexity: O(n). Space complexity: O(n).
     *
     * @param nums input array (may contain negatives and zeros)
     * @param k    target sum
     * @return length of the longest subarray summing to {@code k}, or 0 if none exists
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        int[] nums = new int[]{4, 1, 1, 1, 2, 3, 5};
        System.out.println(maxSubArrayLen(nums, 5));
    }
}
