package dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int getKthSmallestElement(int[] nums, int k) {
        if (nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(getKthSmallestElement(new int[]{}, 3));
        System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 100));
        System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, -1));
    }
}
