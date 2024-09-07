import java.util.Arrays;

public class MeasuringExecutionTime {
    // Sample task
    public static void sort(int[] arr) {
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

        sort(left);
        sort(right);

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
        int[] arr = {
                27, 81, 89, 34, 49,
                94, 97, 98, 67, 15,
                29, 10, 42, 17, 95,
                22, 87, 9, 18, 8,
                99, 21, 70, 46, 76,
                1, 13, 69, 54, 80
        };

        System.out.println("Unsorted array: " + Arrays.toString(arr));

        // Mark the starting time of the sample task
        long start = System.nanoTime();

        // -----Performing the sample task----- //
        sort(arr);
        // ------------------------------------ //

        // Mark the ending time of the sample task
        long end = System.nanoTime();
        // Calculate the duration
        double duration = (double) (end - start) / 1000000; // Measure in milliseconds

        /*
          Without the division by 10^x, the unit of duration defaults to nanoseconds.
          Divide the duration in nanoseconds by:
           - 1000 to measure in microseconds (1 microsecond = 1000 nanoseconds)
           - 1000000 to measure in milliseconds (1 millisecond = 1000000 nanoseconds)
           - 1000000000 to measure in seconds (1 second = 1000000000 nanoseconds
         */

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("The execution took " + duration + " milliseconds to finish");
    }
}