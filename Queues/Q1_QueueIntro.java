// Q1. What is a Queue? Basic implementation and principle (FIFO).

import java.util.LinkedList;
import java.util.Queue;

public class Q1_QueueIntro {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // FIFO: insert 1, 2, 3; remove should give 1, 2, 3
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
