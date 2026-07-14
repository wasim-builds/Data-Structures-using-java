/**
 * Design Circular Deque (LeetCode 641)
 * Design your implementation of the circular double-ended queue (deque).
 */
public class DesignCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * Initializes the deque with a maximum size of k.
     * @param k The capacity of the deque
     */
    public DesignCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = k - 1;
        size = 0;
    }
    
    /**
     * Adds an item at the front of Deque. Returns true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }
    
    /**
     * Adds an item at the rear of Deque. Returns true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }
    
    /**
     * Deletes an item from the front of Deque. Returns true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    /**
     * Deletes an item from the rear of Deque. Returns true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    /**
     * Returns the front item from the Deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }
    
    /**
     * Returns the last item from Deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }
    
    /**
     * Returns true if the deque is empty, or false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns true if the deque is full, or false otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }
}
