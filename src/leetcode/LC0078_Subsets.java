package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0078_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), result);

        return result;
    }

    private static void findSubsets(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            findSubsets(i+1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }
}
