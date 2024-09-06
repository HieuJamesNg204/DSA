package algorithms;

import java.util.Arrays;

public class _08_RecursiveBubbleSort {
    public static void bubbleSort(int[] arr, int sortedIndex) {
        if (sortedIndex < 1) {
            return;
        }

        rearrangeOrder(arr, 0, sortedIndex);
        bubbleSort(arr, sortedIndex - 1);
    }

    public static void rearrangeOrder(int[] arr, int i, int sortedIndex) {
        if (i < sortedIndex - 1) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

            rearrangeOrder(arr, i + 1, sortedIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {94, 93, 12, 10, 71, 98, 19, 89, 37, 49};

        System.out.println("Original array: " + Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}