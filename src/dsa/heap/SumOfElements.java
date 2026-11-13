package dsa.heap;

/**
 * SumOfElements
 * 
 * Sums the elements that lie strictly between the k1th and k2th smallest elements.
 *
 * <p>Problem: Given an array and two numbers k1 and k2, find the sum of all elements
 * whose value is greater than the k1th smallest and less than the k2th smallest element.
 *
 * <p>Example:
 * <pre>
 * Input: arr = [1, 3, 12, 5, 15, 11], k1 = 3, k2 = 6
 * Output: 23  (the 3rd smallest is 5, the 6th is 15; 12 + 11 = 23)
 * </pre>
 *
 * <p>Approach: Use {@link KthSmallestElement} to find both boundary values, then do one
 * pass over the array adding every element strictly between them.
 *
 * <p>Time Complexity: O(n log k2)
 * <p>Space Complexity: O(k2)
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SumOfElements {

    /**
     * Main method to demonstrate the sum between the 3rd and 6th smallest elements.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SumOfElements obj = new SumOfElements();
        System.out.println(obj.getSum(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
    }

    /**
     * Returns the sum of elements strictly between the k1th and k2th smallest elements.
     *
     * @param arr the input array of integers
     * @param k1  1-based rank of the lower boundary element
     * @param k2  1-based rank of the upper boundary element
     * @return the sum of elements with value greater than the k1th smallest and less than
     *         the k2th smallest, or 0 if the array is empty
     */
    public int getSum(int[] arr, int k1, int k2) {
        if (arr.length == 0) {
            return 0;
        }

        int k1thSmallest = KthSmallestElement.getKthSmallestElement(arr, k1);
        int k2thSmallest = KthSmallestElement.getKthSmallestElement(arr, k2);
        int total = 0;
        for (int element : arr) {
            if (element > k1thSmallest && element < k2thSmallest) {
                total += element;
            }
        }

        return total;
    }
}
