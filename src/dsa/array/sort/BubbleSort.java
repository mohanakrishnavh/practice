package dsa.array.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 1, 5, 3};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
