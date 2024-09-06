package algorithms;

public class _06_InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (arr[left] <= target && target <= arr[right] && left <= right) {
            int probe = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);

            if (arr[probe] < target) {
                left = probe + 1;
            } else if (arr[probe] > target) {
                right = probe - 1;
            } else {
                return probe;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 10, 29, 47, 60, 69, 80, 98};
        int target = 8;

        int index = interpolationSearch(arr, target);

        if (index == -1) {
            System.out.println("Target not found in the array");
        } else {
            System.out.println("Target found at index " + index);
        }
    }
}