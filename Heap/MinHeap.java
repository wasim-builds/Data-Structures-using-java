import java.util.*;

/**
 * Min Heap (Priority Queue) Implementation
 * Time Complexity:
 * - Insert: O(log n)
 * - Extract Min: O(log n)
 * - Get Min: O(1)
 * - Heapify: O(n)
 * Space Complexity: O(n)
 * 
 * Applications:
 * - Priority scheduling
 * - Dijkstra's algorithm
 * - Huffman coding
 * - K-way merge
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(int[] array) {
        heap = new ArrayList<>();
        for (int val : array) {
            heap.add(val);
        }
        buildHeap();
    }

    // Get parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Get left child index
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Get right child index
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Swap two elements
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert element into heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Move element up to maintain heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Extract minimum element
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);

        return min;
    }

    // Move element down to maintain heap property
    private void heapifyDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
            minIndex = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
            minIndex = right;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            heapifyDown(minIndex);
        }
    }

    // Get minimum without removing
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Build heap from array (heapify)
    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Get size
    public int size() {
        return heap.size();
    }

    // Check if empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Delete specific element
    public boolean delete(int value) {
        int index = heap.indexOf(value);
        if (index == -1) {
            return false;
        }

        if (index == heap.size() - 1) {
            heap.remove(index);
            return true;
        }

        heap.set(index, heap.remove(heap.size() - 1));

        // Either heapify up or down
        if (index > 0 && heap.get(index) < heap.get(parent(index))) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }

        return true;
    }

    // Decrease key value
    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (newValue > heap.get(index)) {
            throw new IllegalArgumentException("New value is greater than current value");
        }

        heap.set(index, newValue);
        heapifyUp(index);
    }

    // Print heap
    public void printHeap() {
        System.out.println("Heap: " + heap);
    }

    // Heap sort using min heap
    public static int[] heapSort(int[] array) {
        MinHeap heap = new MinHeap(array);
        int[] sorted = new int[array.length];

        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = heap.extractMin();
        }

        return sorted;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        // Insert elements
        System.out.println("Inserting: 5, 3, 8, 1, 9, 2");
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(9);
        heap.insert(2);

        heap.printHeap();

        // Peek minimum
        System.out.println("\nMinimum element: " + heap.peek());

        // Extract minimum
        System.out.println("\nExtracting minimum elements:");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");
        }
        System.out.println();

        // Build heap from array
        System.out.println("\nBuilding heap from array [4, 10, 3, 5, 1]:");
        MinHeap heap2 = new MinHeap(new int[] { 4, 10, 3, 5, 1 });
        heap2.printHeap();

        // Heap sort
        System.out.println("\nHeap Sort:");
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Original: " + Arrays.toString(array));
        int[] sorted = heapSort(array);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
