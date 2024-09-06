package algorithms;

public class _02_RecursiveLinearSearch {
    public static int linearSearch(int[] arr, int target, int index) {
        if (index < arr.length) {
            if (arr[index] == target) {
                return index;
            }

            return linearSearch(arr, target, index + 1);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 4, 1, 6, 9, 3, 10, 5};
        int target = 4;

        int index = linearSearch(arr, target, 0);

        if (index == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index " + index);
        }
    }
}