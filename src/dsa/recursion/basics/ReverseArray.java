package dsa.recursion.basics;

/**
 * ReverseArray
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ReverseArray {
    public static void reverse(int[] arr) {
        reverseHelper(arr, 0);
    }

    private static void reverseHelper(int[] arr, int i) {
        if (i >= arr.length/2) {
            return;
        }

        swap(arr, i , arr.length - i - 1);
        reverseHelper(arr, i + 1);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
