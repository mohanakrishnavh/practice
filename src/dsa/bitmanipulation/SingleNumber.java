package dsa.bitmanipulation;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single = single ^ num;
        }

        return single;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 1, 2, 5, 6, 5, 7, 7, 6}));
    }
}
