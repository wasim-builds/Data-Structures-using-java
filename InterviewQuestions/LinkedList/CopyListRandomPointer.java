package InterviewQuestions.LinkedList;

import java.util.*;

/**
 * LeetCode 138: Copy List with Random Pointer
 * 
 * Problem: A linked list is given such that each node contains an additional
 * random pointer
 * which could point to any node in the list or null. Return a deep copy of the
 * list.
 * 
 * Approach: HashMap to map original nodes to copied nodes
 * - First pass: Create all nodes and store in map
 * - Second pass: Set next and random pointers
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for hashmap
 */
public class CopyListRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        // First pass: Create all nodes
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: Set next and random pointers
        curr = head;
        while (curr != null) {
            Node copiedNode = map.get(curr);
            copiedNode.next = map.get(curr.next);
            copiedNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // Alternative: O(1) space solution using interweaving
    public static Node copyRandomListOptimized(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create copied nodes interweaved with original
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Case 1: Simple list with random pointers
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copied = copyRandomList(node1);
        System.out.println("Test 1: List copied successfully");
        System.out.println("Original head: " + node1.val + ", Copied head: " + copied.val);
        System.out.println("Different objects: " + (node1 != copied));

        // Test optimized version
        Node copied2 = copyRandomListOptimized(node1);
        System.out.println("\nOptimized version:");
        System.out.println("Original head: " + node1.val + ", Copied head: " + copied2.val);
        System.out.println("Different objects: " + (node1 != copied2));
    }
}
