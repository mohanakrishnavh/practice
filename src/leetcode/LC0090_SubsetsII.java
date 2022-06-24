package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0090_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, new ArrayList<>(), result);

        return result;
    }

    private static void findSubsets(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }

            subset.add(nums[i]);
            findSubsets(i+1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
