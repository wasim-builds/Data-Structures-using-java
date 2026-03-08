import java.util.*;

/**
 * Deque (Double-Ended Queue) Implementation using Doubly Linked List
 * Time Complexity:
 * - addFirst/addLast: O(1)
 * - removeFirst/removeLast: O(1)
 * - peekFirst/peekLast: O(1)
 * Space Complexity: O(n)
 * 
 * Applications:
 * - Sliding window problems
 * - Browser history (back/forward)
 * - Undo/Redo operations
 * - Task scheduling
 */
public class Deque<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add element at the front
    public void addFirst(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    // Add element at the rear
    public void addLast(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;
    }

    // Remove element from front
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        T data = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
        return data;
    }

    // Remove element from rear
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        T data = rear.data;

        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
        return data;
    }

    // Peek front element
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return front.data;
    }

    // Peek rear element
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return rear.data;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Display deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        Node current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("<- Rear");
    }

    // Clear deque
    public void clear() {
        front = rear = null;
        size = 0;
    }

    // Sliding Window Maximum using Deque
    public static int[] slidingWindowMaximum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from rear
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add to result when window is complete
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        System.out.println("Adding elements to deque:");
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);
        deque.addFirst(-1);

        deque.display();

        System.out.println("\nPeek operations:");
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        System.out.println("\nRemoving from front: " + deque.removeFirst());
        System.out.println("Removing from rear: " + deque.removeLast());

        deque.display();

        System.out.println("\nSize: " + deque.size());

        // Sliding Window Maximum example
        System.out.println("\n--- Sliding Window Maximum ---");
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);
        int[] maxWindow = slidingWindowMaximum(arr, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(maxWindow));
    }
}
