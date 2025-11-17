package dsa.array.slidingwindow;

/**
 * MaximumSubArraySum
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MaximumSubArraySum {

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

    public static void main(String[] args) {
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 3));
        System.out.println(getMaxSubArraySum(new int[]{2, 5, 1, 8, 2, 9, 1}, 0));
        System.out.println(getMaxSubArraySum(new int[]{}, 3));
    }

}
