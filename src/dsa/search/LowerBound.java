package dsa.search;

/**
 * LowerBound
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LowerBound {
    public static int findLowerBound(int []arr, int x) {
        // Write your code here
        int low = 0, high = arr.length - 1;
        int lowerBound = arr.length;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] >= x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }

    public static void main(String[] args) {
        System.out.println(findLowerBound(new int[]{1, 2, 2, 3}, 0));
        System.out.println(findLowerBound(new int[]{1, 2, 2, 3}, 4));
        System.out.println(findLowerBound(new int[]{3, 5, 8, 15, 19}, 5));
    }
}
