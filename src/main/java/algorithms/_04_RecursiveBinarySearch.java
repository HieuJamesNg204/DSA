package algorithms;

public class _04_RecursiveBinarySearch {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right);
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, left, mid - 1);
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 10, 29, 47, 60, 69, 80, 98};
        int target = 8;

        int index = binarySearch(arr, target, 0, arr.length - 1);

        if (index == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index " + index);
        }
    }
}