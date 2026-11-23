package dsa.array.slidingwindow.fixedwindow;

/**
 * MaximumSubArraySum
 * 
 * Finds the maximum sum of any subarray of fixed size {@code k} using a fixed-size sliding window.
 *
 * <p>The window sum is updated in O(1) per step by adding the entering element and subtracting
 * the one that leaves, instead of recomputing the sum for each window.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MaximumSumSubarray {

    /**
     * Returns the maximum sum over all windows of size {@code k}.
     *
     * @param arr the input array
     * @param k   the window size
     * @return the maximum window sum, or 0 if the array is empty or {@code k} is 0
     */
    private static int getMaxSubArraySum(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length) {
            sum += arr[j];
            // To maintain the window of size k
            if (j - i + 1 == k) {
                // Calculate the max for sub array
                max = Math.max(max, sum);

                // Remove start index element and move start
                sum -= arr[i];
                i++;
            }

            j++;
        }

        return max;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 0));
        System.out.println(getMaxSubArraySum(new int[]{}, 3));
    }

}
