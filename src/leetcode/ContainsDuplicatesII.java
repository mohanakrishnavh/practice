package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesII {
    public static boolean containsNearbyDuplicates(int[] nums, int k) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        valueIndexMap.put(nums[0], 0);

        for (int i=1; i<nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i]) && Math.abs(i-valueIndexMap.get(nums[i]))<=k) {
                return true;
            }

            valueIndexMap.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicates(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicates(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicates(new int[]{1,2,3,1,2,3}, 2));
    }

}
