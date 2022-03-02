package dsa.slidingwindow;

public class MaximumSumSubArray {
    private static int getMaximumSumSubArray(int[] arr, int n, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int maximumSum = Integer.MIN_VALUE;

        while (end < n) {
            sum += arr[end];

            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {
                maximumSum = Math.max(sum, maximumSum);
                sum = sum - arr[start];
                start++;
                end++;
            }
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumSumSubArray(new int[]{2, 5, 1, 8, 2, 9, 1}, 7, 3));
    }
}
