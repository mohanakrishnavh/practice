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

        int left = 0, right = 0;
        Queue<Integer> negatives = new LinkedList<>();
        while (right < arr.length) {
            if (arr[right] < 0) {
                negatives.add(arr[right]);
            }

            if (right - left + 1 == k) {
                int firstNegative = 0;
                if (!negatives.isEmpty()) {
                    firstNegative = negatives.peek();

                    if (arr[left] == negatives.peek()) {
                        negatives.poll();
                    }
                }

                firstNegatives.add(firstNegative);
                left++;
            }

            right++;
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
