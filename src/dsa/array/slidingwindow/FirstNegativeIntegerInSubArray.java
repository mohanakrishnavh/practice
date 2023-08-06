package dsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeIntegerInSubArray {

    public static List<Integer> getFirstNegativeInteger(int[] arr, int k) {
        List<Integer> firstNegativeIntegers = new ArrayList<>();
        if (arr.length == 0 || k == 0) {
            return firstNegativeIntegers;
        }

        int start = 0, end = 0;
        Queue<Integer> negatives = new LinkedList<>();
        while (end < arr.length) {
            if (arr[end] < 0) {
                negatives.add(arr[end]);
            }

            if (end - start + 1 == k) {
                int windowResult = 0;
                if (!negatives.isEmpty()) {
                    windowResult = negatives.peek();

                    if (arr[start] == negatives.peek()) {
                        negatives.poll();
                    }
                }

                firstNegativeIntegers.add(windowResult);
                start++;
            }

            end++;
        }

        return firstNegativeIntegers;
    }
    public static void main(String[] args) {
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 3));
        System.out.println(getFirstNegativeInteger(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 0));
        System.out.println(getFirstNegativeInteger(new int[]{}, 3));
    }
}
