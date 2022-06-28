package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        findSubsets(0, arr, new ArrayList<>(), result);

        return result;
    }

    private static void findSubsets(int index, int[] arr, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i-1]) {
                continue;
            }

            subset.add(arr[i]);
            findSubsets(i+1, arr, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
