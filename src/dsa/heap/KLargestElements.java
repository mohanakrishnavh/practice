package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
    public static Integer[] getKLargestElements(Integer[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKLargestElements(new Integer[]{7, 10, 4, 3, 20, 15}, 3)));
    }
}
