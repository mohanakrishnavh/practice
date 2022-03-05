package dsa.slidingwindow;

public class MaximumSumSubArray {
    private static int getMaximumSumSubArray(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int maximumSum = Integer.MIN_VALUE;

        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == k) {
                maximumSum = Math.max(sum, maximumSum);
                sum = sum - arr[i];
                i++;
            }
            j++;
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumSumSubArray(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));
    }
}
