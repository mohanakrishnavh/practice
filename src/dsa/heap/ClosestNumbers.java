package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestNumbers {
    public static int[] getKClosest(int[] nums, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[0] : b[0] - a[0]);
        for (int num : nums) {
            maxHeap.add(new int[]{Math.abs(x - num), num});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] kClosest = new int[k];
        int index = 0;
        while (maxHeap.size() > 0) {
            kClosest[index++] = maxHeap.poll()[1];
        }

        return kClosest;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKClosest(new int[]{5, 6, 6, 7, 8, 9}, 4, 7)));
    }
}
