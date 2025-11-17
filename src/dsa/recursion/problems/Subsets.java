package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Subsets {
    public static List<List<Integer>> findSubsets(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), subsets);

        return subsets;
    }

    private static void findSubsets(int index, int[] arr, List<Integer> subset, List<List<Integer>> subsets) {
        if (index == arr.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Pick the index element
        subset.add(arr[index]);
        findSubsets(index + 1, arr, subset, subsets);
        subset.remove(subset.size()-1);

        // Do not pick the index element
        findSubsets(index + 1, arr, subset, subsets);
    }

    public static void main(String[] args) {
        System.out.println(findSubsets(new int[]{2, 3}));
        System.out.println(findSubsets(new int[]{3, 1, 2}));
    }
}
