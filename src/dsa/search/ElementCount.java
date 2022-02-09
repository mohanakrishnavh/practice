package dsa.search;

public class ElementCount {
    public static int firstOccurrence(int[] arr, int x) {
        int minIndex = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {
                minIndex = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minIndex;
    }

    public static int lastOccurrence(int[] arr, int x) {
        int maxIndex = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {
                maxIndex = mid;
                start = mid + 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return maxIndex;
    }

    public static int elementCount(int[] arr, int x) {
        int minIndex = firstOccurrence(arr, x);
        int maxIndex = lastOccurrence(arr, x);

        if (minIndex == -1 && maxIndex == -1) {
            return 0;
        }

        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(ElementCount.elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 10));
        System.out.println(ElementCount.elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 18));
        System.out.println(ElementCount.elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 100));
    }
}
