package dsa.heap;

import java.util.PriorityQueue;

/**
 * Connect Ropes Problem (Minimum Cost to Connect Ropes)
 * 
 * <p>Given an array of rope lengths, connect all ropes into one rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 * 
 * <p>Problem: You have n ropes of different lengths. You need to connect these ropes into
 * one rope. The cost to connect two ropes is equal to the sum of their lengths. Find the
 * minimum cost to connect all ropes.
 * 
 * <p>Example:
 * <pre>
 * Input: ropeLengths = [1, 2, 3, 4, 5]
 * Output: 33
 * Explanation:
 * - Connect 1 and 2: cost = 3, remaining = [3, 3, 4, 5]
 * - Connect 3 and 3: cost = 6, total = 9, remaining = [4, 5, 6]
 * - Connect 4 and 5: cost = 9, total = 18, remaining = [6, 9]
 * - Connect 6 and 9: cost = 15, total = 33, remaining = [15]
 * Total minimum cost = 33
 * </pre>
 * 
 * <p>Approach (Greedy with Min Heap):
 * <ol>
 *   <li>Add all rope lengths to a min heap</li>
 *   <li>While more than one rope remains:
 *     <ul>
 *       <li>Extract two ropes with minimum lengths</li>
 *       <li>Connect them (add their lengths)</li>
 *       <li>Add the cost to total</li>
 *       <li>Put the combined rope back into the heap</li>
 *     </ul>
 *   </li>
 *   <li>Return the total cost</li>
 * </ol>
 * 
 * <p>Why greedy works: Always connecting the two shortest ropes minimizes the cost
 * because shorter ropes get added to the total cost fewer times.
 * 
 * <p>Time Complexity: O(n log n) where n is the number of ropes
 * <ul>
 *   <li>O(n) to build the initial heap</li>
 *   <li>O(n log n) for n-1 iterations of extract-min and insert operations</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) for the min heap
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ConnectRopes {
    
    /**
     * Calculates the minimum cost to connect all ropes into one.
     * 
     * <p>Uses a greedy algorithm with a min heap to always connect the two
     * shortest ropes first, which minimizes the total cost.
     * 
     * @param ropeLengths array of individual rope lengths
     * @return the minimum total cost to connect all ropes, or 0 if 0 or 1 rope
     */
    private static int getMinimumCost(int[] ropeLengths) {
        if (ropeLengths.length <= 1) {
            return 0;
        }

        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer ropeLength : ropeLengths) {
            minHeap.offer(ropeLength);
        }

        while (minHeap.size() >= 2) {
            Integer first = minHeap.poll();
            Integer second = minHeap.poll();
            cost = cost + first + second;
            minHeap.add(first + second);
        }

        return cost;
    }

    /**
     * Main method to demonstrate the minimum cost rope connection problem.
     * 
     * <p>Test case: ropeLengths = [1, 2, 3, 4, 5]
     * <p>Expected output: 33
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(getMinimumCost(new int[]{1, 2, 3, 4, 5}));
    }
}
