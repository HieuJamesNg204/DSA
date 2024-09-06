package algorithms;

import java.util.Arrays;

public class _17_MedianOfThreePivotQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findMedianOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int a = arr[left];
        int b = arr[mid];
        int c = arr[right];

        if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return left;
        } else if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return mid;
        } else {
            return right;
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionPos = partition(arr, left, right);
            quickSort(arr, left, partitionPos - 1);
            quickSort(arr, partitionPos + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivotIndex = findMedianOfThree(arr, left, right);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {51, 49, 72, 64, 36, 99, 77, 40, 32, 12};

        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}