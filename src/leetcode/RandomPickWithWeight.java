package leetcode;

/**
 * RandomPickWithWeight
 * 
 * Picks an index at random with probability proportional to its weight.
 *
 * <p>Approach: Precompute prefix sums of the weights. To pick, draw a random target in
 * [0, totalSum) and binary search for the first prefix sum that is not less than it.
 *
 * <p>Time Complexity: O(n) to construct, O(log n) per pick. Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RandomPickWithWeight {
    int[] cumulativeSum;
    int totalSum;

    /**
     * Builds the cumulative weight table.
     *
     * @param w the weight of each index
     */
    public RandomPickWithWeight(int[] w) {
        cumulativeSum = new int[w.length];
        totalSum = 0;
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            cumulativeSum[i] += totalSum;
        }
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        RandomPickWithWeight random = new RandomPickWithWeight(new int[]{1, 2, 3});
        System.out.println(random.pickIndex());
    }

    /**
     * Returns a randomly chosen index, weighted by the supplied weights.
     *
     * @return the picked index
     */
    public int pickIndex() {
        double target = Math.random() * totalSum;
        int start = 0;
        int end = cumulativeSum.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > cumulativeSum[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
