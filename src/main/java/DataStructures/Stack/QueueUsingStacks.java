package Stack;

import java.util.Stack;

public class QueueUsingStacks {
    // Implement a Queue using two Stacks
    
    private Stack<Integer> s1; // for enqueue
    private Stack<Integer> s2; // for dequeue
    
    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // Add element to queue - O(1)
    public void push(int x) {
        s1.push(x);
    }
    
    // Remove element from queue - Amortized O(1)
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        if (s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        return s2.pop();
    }
    
    // Get front element - Amortized O(1)
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        if (s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        return s2.peek();
    }
    
    // Check if empty - O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek());   // 1
        System.out.println("Pop: " + queue.pop());     // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}
