package dsa.array.slidingwindow;

public class MaximumSubArraySum {

    private static int getMaxSubArraySum(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return 0;
        }

        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            // To maintain the window of size k
            if (end - start + 1 == k) {
                // Calculate the max for sub array
                max = Math.max(max, sum);

                // Remove start index element and move start
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return max;
    }


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
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 0));
        System.out.println(getMaxSubArraySum(new int[]{}, 3));
    }
}
