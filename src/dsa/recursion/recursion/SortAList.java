package dsa.recursion.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SortAList
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SortAList {
    public static void sort(List<Integer> nums) {
        if (nums.size() == 1) {
            return;
        }

        int temp = nums.get(nums.size() - 1);
        nums.remove(nums.size()-1);
        sort(nums);
        insert(nums, temp);
    }

    private static void insert(List<Integer> nums, int temp) {
        if (nums.isEmpty() || nums.get(nums.size() - 1) <= temp) {
            nums.add(temp);
            return;
        }

        int val = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        insert(nums, temp);
        nums.add(val);
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 7, 6, 4, 9));
        sort(nums);
        System.out.println(nums);
    }
}
