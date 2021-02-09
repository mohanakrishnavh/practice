package interview.microsoft;

import java.util.HashSet;
import java.util.Set;

public class LargestKWithPositiveAndNegativeK {
    public static int findLargestK(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(-1*num)) {
                max = Math.max(max, Math.abs(num));
            } else {
                numsSet.add(num);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLargestK(new int[]{3, 2, -2, 5, -3}));
        System.out.println(findLargestK(new int[]{1, 2, 3, -4}));
    }
}
