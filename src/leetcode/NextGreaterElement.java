package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NextGreaterElement
 * 
 * Finds the next greater element for each value of one array within another.
 *
 * <p>Problem: For each element of {@code nums1} (a subset of {@code nums2}), find the first
 * greater element to its right in {@code nums2}, or -1 if none exists.
 *
 * <p>Approach: Traverse {@code nums2} from right to left with a monotonic stack, recording the
 * next greater element of each value in a map, then look up each element of {@code nums1}.
 *
 * <p>Time Complexity: O(n + m). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NextGreaterElement {
    /**
     * Returns the next greater element in {@code nums2} for every element of {@code nums1}.
     *
     * @param nums1 the values to query (each must appear in nums2)
     * @param nums2 the array to search in
     * @return an array aligned with nums1 holding each next greater element, or -1
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngrMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ngrMap.put(nums2[i], -1);
            } else if (stack.peek() > nums2[i]) {
                ngrMap.put(nums2[i], stack.peek());
            } else {
                while (stack.size() > 0 && stack.peek() <= nums2[i]) {
                    stack.pop();
                }

                ngrMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] ngr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ngr[i] = ngrMap.get(nums1[i]);
        }

        return ngr;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(NextGreaterElement.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
