package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestNumbers {
    public static int[] getKClosestNumbers(int[] nums, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : b[0] - a[0]);
        for (int num : nums) {
            maxHeap.add(new int[]{Math.abs(x - num), num});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] kClosestNumbers = new int[k];
        int index = 0;
        while (maxHeap.size() > 0) {
            kClosestNumbers[index++] = maxHeap.poll()[1];
        }

        return kClosestNumbers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKClosestNumbers(new int[]{5, 6, 6, 7, 8, 9}, 4, 7)));
        System.out.println(Arrays.toString(getKClosestNumbers(new int[]{10, 2, 14, 4, 7, 6}, 3, 5)));
    }
}
