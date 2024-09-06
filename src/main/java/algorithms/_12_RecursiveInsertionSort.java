package algorithms;

import java.util.Arrays;

public class _12_RecursiveInsertionSort {
    public static void recursiveInsertionSort(int[] arr, int i) {
        if (i < arr.length) {
            int key = arr[i];
            int j = i - 1;

            int insertPos = insertKey(arr, key, j);
            arr[insertPos] = key;

            recursiveInsertionSort(arr, i + 1);
        }
    }

    public static int insertKey(int[] arr, int key, int j) {
        if (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            return insertKey(arr, key, j - 1);
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = {46, 13, 31, 57, 94, 19, 22, 81, 38, 75};

        System.out.println("Unsorted arr: " + Arrays.toString(arr));
        recursiveInsertionSort(arr, 1);
        System.out.println("Sorted arr: " + Arrays.toString(arr));
    }
}