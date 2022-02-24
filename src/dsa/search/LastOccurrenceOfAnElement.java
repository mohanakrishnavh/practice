package dsa.search;

public class LastOccurrenceOfAnElement {
    public static int getLastOccurrence(int[] nums, int x) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                index = mid;
                start = mid + 1;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(getLastOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 10));
        System.out.println(getLastOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 1));
    }
}
