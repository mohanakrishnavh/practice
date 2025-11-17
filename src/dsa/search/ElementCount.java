package dsa.search;

/**
 * ElementCount
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ElementCount {
    public static int getFirstOccurrence(int[] nums, int x) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                index = mid;
                end = mid - 1;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public static int getLastOccurrence(int[] nums, int x) {
        int maxIndex = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                maxIndex = mid;
                start = mid + 1;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return maxIndex;
    }

    public static int elementCount(int[] nums, int x) {
        int minIndex = getFirstOccurrence(nums, x);
        int maxIndex = getLastOccurrence(nums, x);

        if (minIndex == -1 && maxIndex == -1) {
            return 0;
        }

        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 10));
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 18));
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 100));
    }
}
