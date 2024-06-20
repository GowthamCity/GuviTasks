package task4;

import java.util.LinkedList;

public class Q5 {
    private LinkedList<Integer> stack;

    public Q5() {
        this.stack = new LinkedList<>();
    }

    // Push method to add elements onto the stack
    public void push(int element) {
        stack.push(element);
        System.out.println("Pushed element: " + element);
    }

    // Pop method to remove and return elements from the stack
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        return stack.pop();
    }

    // Method to display all elements in the stack
    public void displayStack() {
        System.out.println("Current elements in stack: " + stack);
    }

    public static void main(String[] args) {
    	Q5 stackExample = new Q5();

        // Pushing elements onto the stack
        stackExample.push(10);
        stackExample.push(20);
        stackExample.push(30);
        stackExample.displayStack();

        // Popping elements from the stack
        System.out.println("Popped element: " + stackExample.pop());
        System.out.println("Popped element: " + stackExample.pop());
        stackExample.displayStack();

        // Popping more elements
        System.out.println("Popped element: " + stackExample.pop());
        stackExample.displayStack();

        // Trying to pop from an empty stack (will throw exception)
        // stackExample.pop();
    }
}
