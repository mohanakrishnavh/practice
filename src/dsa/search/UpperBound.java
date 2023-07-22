package dsa.search;

public class UpperBound {
    public static int findUpperBound(int []arr, int x){
        int low = 0, high = arr.length - 1;
        int upperBound = arr.length;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] > x) {
                high = mid - 1;
                upperBound = mid;
            } else {
                low = mid + 1;
            }
        }

        return upperBound;
    }

    public static void main(String[] args) {
        System.out.println(findUpperBound(new int[]{1, 2, 2, 3}, 2));
        System.out.println(findUpperBound(new int[]{1, 2, 2, 3}, 100));
    }
}
