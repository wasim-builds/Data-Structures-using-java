// Q9. Priority Queue vs Regular Queue

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q9_PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default, min-heap

        queue.offer(10); queue.offer(5); queue.offer(7);
        pq.offer(10); pq.offer(5); pq.offer(7);

        System.out.println("Queue order (FIFO):");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("PriorityQueue order (Priority):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}