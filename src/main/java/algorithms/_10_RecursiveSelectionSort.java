package algorithms;

import java.util.Arrays;

public class _10_RecursiveSelectionSort {
    public static void selectionSort(int[] arr, int i) {
        if (i < arr.length - 1) {
            int minIndex = findMinIndex(arr, i, i + 1);

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            selectionSort(arr, i + 1);
        }
    }

    public static int findMinIndex(int[] arr, int assumedMinIndex, int i) {
        if (i < arr.length) {
            if (arr[i] < arr[assumedMinIndex]) {
                assumedMinIndex = i;
            }

            return findMinIndex(arr, assumedMinIndex, i + 1);
        }

        return assumedMinIndex;
    }

    public static void main(String[] args) {
        int[] arr = {69, 34, 50, 88, 43, 40, 63, 70, 4, 20};

        System.out.println("Original array: " + Arrays.toString(arr));
        selectionSort(arr, 0);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}