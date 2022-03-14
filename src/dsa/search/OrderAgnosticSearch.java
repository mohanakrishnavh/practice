package dsa.search;

public class OrderAgnosticSearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] == nums[end]) {
            if (target == nums[start]) {
                return 0;
            }
        }

        if (nums[start] < nums[end]) {
            return BinarySearch.search(nums, target);
        } else {
            return ReverseBinarySearch.search(nums, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 12));
        System.out.println(search(new int[]{1, 3, 5, 10, 12, 13}, 100));
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, 100));
        System.out.println(search(new int[]{100, 30, 5, 4, 3, 1}, -1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(OrderAgnosticSearch.search(new int[]{1, 1, 1, 1, 1}, -1));
    }
}
