package data_structures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _03_PriorityQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("B");
        queue.offer("C");
        queue.offer("A");
        queue.offer("F");
        queue.offer("D");

        System.out.println("Priority queue: " + queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}