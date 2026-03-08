import java.util.*;

/**
 * Max Heap Implementation
 * Time Complexity:
 * - Insert: O(log n)
 * - Extract Max: O(log n)
 * - Get Max: O(1)
 * Space Complexity: O(n)
 */
public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(int[] array) {
        heap = new ArrayList<>();
        for (int val : array) {
            heap.add(val);
        }
        buildHeap();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) > heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int max = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left) > heap.get(maxIndex)) {
            maxIndex = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(maxIndex)) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void printHeap() {
        System.out.println("Heap: " + heap);
    }

    // Find K largest elements
    public static List<Integer> findKLargest(int[] array, int k) {
        MaxHeap heap = new MaxHeap(array);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            result.add(heap.extractMax());
        }

        return result;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        System.out.println("Inserting: 5, 3, 8, 1, 9, 2");
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(9);
        heap.insert(2);

        heap.printHeap();

        System.out.println("\nMaximum element: " + heap.peek());

        System.out.println("\nExtracting maximum elements:");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMax() + " ");
        }
        System.out.println();

        // Find K largest
        int[] array = { 3, 2, 1, 5, 6, 4 };
        int k = 3;
        System.out.println("\nFind " + k + " largest elements in " + Arrays.toString(array));
        System.out.println("Result: " + findKLargest(array, k));
    }
}
