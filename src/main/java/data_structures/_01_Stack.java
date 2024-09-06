package data_structures;

import java.util.Stack;

public class _01_Stack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println("Stack is empty? " + stack.isEmpty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");

        System.out.println("Stack: " + stack);

        String popped = stack.pop();
        System.out.println("Popped game: " + popped);
        System.out.println("Peeking the top element without removing: " + stack.peek());
        System.out.println("Index of Minecraft: " + stack.search("Minecraft"));
    }
}