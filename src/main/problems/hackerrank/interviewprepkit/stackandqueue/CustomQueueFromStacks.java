package main.problems.hackerrank.interviewprepkit.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class CustomQueueFromStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {
    private final Stack<T> removalStack = new Stack<>();
    private final Stack<T> additionStack = new Stack<>();

    public void enqueue(T inputElement) {
        additionStack.push(inputElement);
    }

    public T peek() {
        if (removalStack.empty()) {
            transferElementsToRemovalStack();
        }
        return removalStack.peek();
    }

    public void dequeue() {
        if (removalStack.empty()) {
            transferElementsToRemovalStack();
        }
        removalStack.pop();
    }

    private void transferElementsToRemovalStack() {
        while (!additionStack.empty()) {
            removalStack.push(additionStack.pop());
        }
    }

}
