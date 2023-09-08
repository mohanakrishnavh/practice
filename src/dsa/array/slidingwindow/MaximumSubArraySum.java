package dsa.array.slidingwindow;

public class MaximumSubArraySum {

    private static int getMaxSubArraySum(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0, sum = 0;
        int max = Integer.MIN_VALUE;
        while (right < arr.length) {
            sum += arr[right];
            // To maintain the window of size k
            if (right - left + 1 == k) {
                // Calculate the max for sub array
                max = Math.max(max, sum);

                // Remove start index element and move start
                sum -= arr[left];
                left++;
            }

            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 0));
        System.out.println(getMaxSubArraySum(new int[]{}, 3));
    }

}
