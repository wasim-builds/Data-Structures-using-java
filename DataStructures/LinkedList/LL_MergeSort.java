/**
 * ============================================================
 * LINKED LIST — MERGE & SORT PATTERN
 * ============================================================
 *
 * PATTERN IDEA:
 * Split, sort or merge lists using dummy head nodes and pointers.
 * A "dummy" node is a fake starting node so you never have to
 * handle a null head as a special case. Very clean technique!
 *
 * PROBLEMS COVERED:
 *  1. Merge Two Sorted Lists
 *  2. Sort a Linked List (Merge Sort)
 *  3. Merge K Sorted Lists
 * ============================================================
 */

import java.util.PriorityQueue;

public class LL_MergeSort {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // -------------------------------------------------------
    // PROBLEM 1: Merge Two Sorted Linked Lists
    // Input:  L1 = 1->2->4,   L2 = 1->3->4
    // Output: 1->1->2->3->4->4
    //
    // HOW: Compare heads of both lists each time and pick the smaller one.
    //      Use a dummy node to avoid null-checking at the start.
    // -------------------------------------------------------
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // dummy starting node
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes (one of them will be null already)
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next; // skip the dummy node
    }

    // -------------------------------------------------------
    // PROBLEM 2: Sort a Linked List (Merge Sort)
    // Input:  4 -> 2 -> 1 -> 3
    // Output: 1 -> 2 -> 3 -> 4
    //
    // HOW:
    // Step 1: Split the list into two halves (use slow/fast to find middle)
    // Step 2: Recursively sort each half
    // Step 3: Merge the two sorted halves
    // TIME: O(N log N)  SPACE: O(log N) call stack
    // -------------------------------------------------------
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // base case

        // Step 1: Find middle and split
        ListNode mid = getMid(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // cut the list in two

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Step 3: Merge the two sorted halves
        return mergeTwoLists(left, right);
    }

    // Helper: Get the middle node (for split in merge sort)
    private static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow is the middle
    }

    // -------------------------------------------------------
    // PROBLEM 3: Merge K Sorted Lists
    // Input:  [1->4->5],  [1->3->4],  [2->6]
    // Output: 1->1->2->3->4->4->5->6
    //
    // HOW: Use a Min-Heap (PriorityQueue).
    //   1. Add the head of each list to the heap.
    //   2. Poll the smallest node, add its next to the heap.
    //   3. Repeat until heap is empty.
    // TIME: O(N log K)  where N = total nodes, K = number of lists
    // -------------------------------------------------------
    public static ListNode mergeKLists(ListNode[] lists) {
        // Min-heap ordered by node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of every list into the heap
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();  // get the current smallest node
            tail.next = smallest;
            tail = tail.next;
            if (smallest.next != null) pq.offer(smallest.next); // add next from same list
        }

        return dummy.next;
    }

    // --- Helpers ---
    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    static void print(ListNode head) {
        while (head != null) { System.out.print(head.val + " -> "); head = head.next; }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Merge Two Sorted Lists
        print(mergeTwoLists(build(new int[]{1, 2, 4}), build(new int[]{1, 3, 4})));
        // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null

        // Sort a Linked List
        print(sortList(build(new int[]{4, 2, 1, 3})));
        // Output: 1 -> 2 -> 3 -> 4 -> null

        // Merge K Sorted Lists
        ListNode[] lists = {
            build(new int[]{1, 4, 5}),
            build(new int[]{1, 3, 4}),
            build(new int[]{2, 6})
        };
        print(mergeKLists(lists));
        // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
    }
}
