package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * KLargestElements
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class KLargestElements {
    public static Integer[] getKLargestElements(Integer[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Converting Priority Queue to Array
        // https://stackoverflow.com/questions/65306475/how-to-cast-object-into-int-in-java
        // return minHeap.toArray(Integer[]:new);
        return minHeap.toArray(new Integer[]{});
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKLargestElements(new Integer[]{7, 10, 4, 3, 20, 15}, 3)));
    }
}
