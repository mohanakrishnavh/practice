package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (indexMap.containsKey(difference)) {
                return new int[]{i, indexMap.get(difference)};
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
