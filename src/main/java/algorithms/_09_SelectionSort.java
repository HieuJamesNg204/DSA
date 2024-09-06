package algorithms;

import java.util.Arrays;

public class _09_SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {69, 34, 50, 88, 43, 40, 63, 70, 4, 20};

        System.out.println("Original array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}