package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    // Implement a Stack using two Queues
    
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element onto stack - O(n)
    public void push(int x) {
        q2.add(x);
        
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Remove top element - O(1)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }
    
    // Get top element - O(1)
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }
    
    // Check if empty - O(1)
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());    // 2
        System.out.println("Pop: " + stack.pop());    // 2
        System.out.println("Empty: " + stack.empty()); // false
    }
}
