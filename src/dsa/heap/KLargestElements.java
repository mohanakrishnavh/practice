package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

    /**
     * Returns the k largest elements from the given array
     *
     * Time Complexity : O(n) - n is the length of the array
     * Space Complexity : (k) - k is size of the heap
     *
     */
    public static int[] getKLargestElements(int[] nums, int k) {
      if (nums.length == 0 || k <=0) {
          return null;
      }

      if (nums.length == k) {
          return nums;
      }

      int[] kLargest = new int[k];
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for (int i : nums) {
          minHeap.add(i);

          if (minHeap.size() > k) {
              minHeap.poll();
          }
      }

      int index = 0;
      while (minHeap.size() > 0) {
          kLargest[index++] = minHeap.poll();
      }

      return kLargest;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(KLargestElements.getKLargestElements(new int[]{7, 10, 4, 3, 20, 15}, 3)));
    }
}
