package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
    public static int[] getKLargestElements(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        if (nums.length == k) {
            return nums;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int index = 0;
        int[] kLargestElements = new int[k];
        while (!priorityQueue.isEmpty()) {
           kLargestElements[index++] = priorityQueue.poll();
        }

        return kLargestElements;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(KLargestElements.getKLargestElements(new int[]{7, 10, 4, 3, 20, 15}, 3)));
    }
}
