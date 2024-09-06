package data_structures;

import java.util.LinkedList;
import java.util.Queue;

public class _02_Queue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Hieu Nguyen");
        queue.offer("Truc Le");
        queue.offer("Chau Nguyen");
        queue.offer("Vy Nguyen");

        System.out.println("Queue: " + queue);
        System.out.println("Queue is empty? " + queue.isEmpty());
        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Size: " + queue.size());
        System.out.println("Contains 'Truc Le'? " + queue.contains("Truc Le"));

        String served = queue.poll();
        System.out.println("Served person: " + served);
        System.out.println("Updated contents of the queue: " + queue);
    }
}