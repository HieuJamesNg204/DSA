package algorithms;

import java.util.Arrays;

public class _13_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < mid) {
                left[i] = arr[i];
            } else {
                right[rightIndex++] = arr[i];
            }
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[i++] = left[leftIndex++];
            } else {
                arr[i++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            arr[i++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            arr[i++] = right[rightIndex++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {69, 34, 50, 88, 43, 40, 63, 70, 4, 20};

        System.out.println("Original array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}