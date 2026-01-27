package InterviewQuestions.LinkedList;

/**
 * LeetCode 143: Reorder List
 * 
 * Problem: Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * Example:
 * Input: 1->2->3->4->5
 * Output: 1->5->2->4->3
 * 
 * Approach: Three steps
 * 1. Find middle using slow/fast pointers
 * 2. Reverse second half
 * 3. Merge two halves alternately
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);
        slow.next = null; // Split the list

        // Step 3: Merge two halves
        ListNode first = head;
        ListNode second = secondHalf;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Helper methods
    private static ListNode createList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Odd length
        ListNode head1 = createList(new int[] { 1, 2, 3, 4, 5 });
        System.out.print("Test 1 Before: ");
        printList(head1);
        reorderList(head1);
        System.out.print("Test 1 After: ");
        printList(head1); // Expected: 1->5->2->4->3

        // Test Case 2: Even length
        ListNode head2 = createList(new int[] { 1, 2, 3, 4 });
        System.out.print("\nTest 2 Before: ");
        printList(head2);
        reorderList(head2);
        System.out.print("Test 2 After: ");
        printList(head2); // Expected: 1->4->2->3

        // Test Case 3: Two nodes
        ListNode head3 = createList(new int[] { 1, 2 });
        System.out.print("\nTest 3 Before: ");
        printList(head3);
        reorderList(head3);
        System.out.print("Test 3 After: ");
        printList(head3); // Expected: 1->2
    }
}
