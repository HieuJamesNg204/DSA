package algorithms;

import java.util.Arrays;

public class _11_InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {69, 34, 50, 88, 43, 40, 63, 70, 4, 20};

        System.out.println("Original array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}