package dsa.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeIntegerInWindow {
    public static List<Integer> getFirstNegativeIntegerInWindow(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> firstNegativeIntegers = new ArrayList<>();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }

            if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    firstNegativeIntegers.add(0);
                } else {
                    firstNegativeIntegers.add(queue.peek());

                    if (queue.peek().equals(arr[i])) {
                        queue.poll();
                    }
                    i++;
                }
            }

            j++;
        }

        return firstNegativeIntegers;
    }

    public static void main(String[] args) {
        System.out.println(getFirstNegativeIntegerInWindow(new int[]{12, -1, -7, 8, -15, 30, 13, 28}, 3));
    }
}
