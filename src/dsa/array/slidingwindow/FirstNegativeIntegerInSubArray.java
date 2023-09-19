package dsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeIntegerInSubArray {

    public static List<Integer> getFirstNegativeInteger(int[] arr, int k) {
        List<Integer> firstNegatives = new ArrayList<>();
        if (arr.length == 0 || k == 0) {
            return firstNegatives;
        }

        int i = 0, j = 0;
        Queue<Integer> negatives = new LinkedList<>();
        while (j < arr.length) {
            if (arr[j] < 0) {
                negatives.add(arr[j]);
            }

            if (j - i + 1 == k) {
                int firstNegative = 0;
                if (!negatives.isEmpty()) {
                    firstNegative = negatives.peek();

                    if (arr[i] == negatives.peek()) {
                        negatives.poll();
                    }
                }

                firstNegatives.add(firstNegative);
                i++;
            }

            j++;
        }

        return firstNegatives;
    }
    public static void main(String[] args) {
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 3));
        System.out.println(getFirstNegativeInteger(new int[]{12, 1, 7, 8, -15, 30, 13, 28}, 3));
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 0));
        System.out.println(getFirstNegativeInteger(new int[]{}, 3));
    }
}
