package dsa.heap;

public class SumOfElements {

    public int getSum(int[] arr, int k1, int k2) {
        if (arr.length == 0) {
            return 0;
        }

        int k1thSmallest = KthSmallestElement.getKthSmallestElement(arr, k1);
        int k2thSmallest = KthSmallestElement.getKthSmallestElement(arr, k2);
        int total = 0;
        for (Integer element : arr) {
            if (element > k1thSmallest && element < k2thSmallest) {
                total += element;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        SumOfElements obj = new SumOfElements();
        System.out.println(obj.getSum(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
    }
}
