package Stack;

import java.util.*;

public class MaxFrequencyStack {
    // Design a stack that pops the most frequent element
    
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;
    
    public MaxFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        if (f > maxFreq) {
            maxFreq = f;
        }
        
        group.computeIfAbsent(f, x -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
    
    public static void main(String[] args) {
        MaxFrequencyStack stack = new MaxFrequencyStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Pop: " + stack.pop());  // 5
        System.out.println("Pop: " + stack.pop());  // 7
        System.out.println("Pop: " + stack.pop());  // 5
        System.out.println("Pop: " + stack.pop());  // 4
    }
}
