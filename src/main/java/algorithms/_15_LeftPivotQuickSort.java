package algorithms;

import java.util.Arrays;

public class _15_LeftPivotQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionPos = partition(arr, left, right);
            quickSort(arr, left, partitionPos - 1);
            quickSort(arr, partitionPos + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        int i = right + 1;
        for (int j = right; j > left; j--) {
            if (arr[j] > pivot) {
                swap(arr, --i, j);
            }
        }

        swap(arr, i - 1, left);
        return i - 1;
    }

    public static void main(String[] args) {
        int[] arr = {51, 49, 72, 64, 36, 99, 77, 40, 32, 12};

        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}