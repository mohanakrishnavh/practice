package dsa.search;

public class ElementCount {
    public static int getFirstOccurrence(int[] arr, int x) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {
                index = mid;
                end = mid - 1;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public static int getLastOccurrence(int[] arr, int x) {
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
        int minIndex = getFirstOccurrence(arr, x);
        int maxIndex = getLastOccurrence(arr, x);

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
