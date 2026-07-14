package DataStructures.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Design Front Middle Back Queue (LeetCode 1670)
 * Design a queue that supports push and pop operations in the front, middle, and back.
 */
public class DesignFrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public DesignFrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        } else if (right.size() > left.size() + 1) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.offerLast(val);
        } else {
            right.offerFirst(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        if (right.isEmpty()) return -1;
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (right.isEmpty()) return -1;
        int val = left.size() == right.size() ? left.pollLast() : right.pollFirst();
        balance();
        return val;
    }

    public int popBack() {
        if (right.isEmpty()) return -1;
        int val = right.pollLast();
        balance();
        return val;
    }
}
