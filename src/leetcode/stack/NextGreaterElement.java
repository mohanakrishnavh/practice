package leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngrMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ngrMap.put(nums2[i], -1);
            } else if (stack.peek() > nums2[i]) {
                ngrMap.put(nums2[i], stack.peek());
            } else {
                while (stack.size()>0 && stack.peek() <= nums2[i]) {
                    stack.pop();
                }

                ngrMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] ngr = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            ngr[i] = ngrMap.get(nums1[i]);
        }

        return ngr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(NextGreaterElement.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
