package data_structures;

import java.util.ArrayList;

public class _05_DynamicArray {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(5);

        for (int i = 1; i <= 5; i++) {
            nums.add(i);
        }

        System.out.println("Array: " + nums);
        nums.add(3, 6);
        System.out.println("Updated array: " + nums);
        System.out.println("Size: " + nums.size());

        System.out.println("Element at index 2: " + nums.get(2));

        nums.set(2, 10);
        System.out.println("Element at index 2 after being updated: " + nums.get(2));

        nums.remove(1);
        System.out.println("After removing the element at index 1: " + nums);
    }
}