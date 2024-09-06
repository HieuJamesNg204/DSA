package algorithms;

public class _03_BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 10, 29, 47, 60, 69, 80, 98};
        int target = 8;

        int index = binarySearch(arr, target);

        if (index == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index " + index);
        }
    }
}