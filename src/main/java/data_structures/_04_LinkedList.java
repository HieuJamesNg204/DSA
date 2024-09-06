package data_structures;

import java.util.LinkedList;

public class _04_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");

        System.out.println("Linked list: " + linkedList);
        System.out.println("Popped element: " + linkedList.pop());

        linkedList.offer("E");
        linkedList.offer("F");
        linkedList.offer("G");
        linkedList.offer("H");

        System.out.println("Linked list after offering some elements: " + linkedList);
        System.out.println("Polled element: " + linkedList.poll());

        linkedList.add(4, "I");
        System.out.println("After adding 'I' at index 4: " + linkedList);

        linkedList.remove("E");
        System.out.println("Removing 'E': " + linkedList);

        System.out.println("Peeking the head: " + linkedList.peekFirst());
        System.out.println("Peeking the tail: " + linkedList.peekLast());

        linkedList.addFirst("Head");
        linkedList.addLast("Tail");
        System.out.println("Adding the head and tail: " + linkedList);

        String head = linkedList.pollFirst();
        String tail = linkedList.pollLast();
        System.out.println(head + " " + tail);
    }
}