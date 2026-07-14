/**
 * ============================================================
 * LINKED LIST — IN-PLACE REVERSAL PATTERN
 * ============================================================
 *
 * PATTERN IDEA:
 * Many linked list problems require reversing some portion of
 * the list without using extra space. The trick is to redirect
 * the `.next` pointers as you walk through the list using
 * three variables: prev, curr, and next.
 *
 *  Before: null <- 1  2 -> 3 -> 4 -> 5
 *  After:  null <- 1 <- 2 <- 3 <- 4 <- 5
 *
 * PROBLEMS COVERED:
 *  1. Reverse the Entire Linked List
 *  2. Reverse a Sub-list (from position left to right)
 *  3. Reverse Every K-Group
 * ============================================================
 */
public class LL_Reversal {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // -------------------------------------------------------
    // PROBLEM 1: Reverse the Entire Linked List
    // Input:  1 -> 2 -> 3 -> 4 -> 5
    // Output: 5 -> 4 -> 3 -> 2 -> 1
    //
    // HOW: Walk forward, at each step flip the arrow to point backward.
    // -------------------------------------------------------
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next before breaking the link
            curr.next = prev;          // flip the arrow
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }
        return prev; // prev is the new head
    }

    // -------------------------------------------------------
    // PROBLEM 2: Reverse Sublist (Left to Right indices, 1-based)
    // Input:  1 -> 2 -> 3 -> 4 -> 5,  left=2, right=4
    // Output: 1 -> 4 -> 3 -> 2 -> 5
    //
    // HOW:
    // Step 1: Walk to the node just before position 'left' (call it prev).
    // Step 2: Reverse the sublist from position left to right.
    // Step 3: Reconnect the reversed portion back to the main list.
    // -------------------------------------------------------
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move prev to node just before 'left'
        for (int i = 1; i < left; i++) prev = prev.next;

        // Step 2: Reverse the sublist
        ListNode curr = prev.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    // -------------------------------------------------------
    // PROBLEM 3: Reverse Nodes in K-Group
    // Input:  1 -> 2 -> 3 -> 4 -> 5,  K = 2
    // Output: 2 -> 1 -> 4 -> 3 -> 5
    //         (last group of 1 stays as-is since less than K)
    //
    // HOW: Check if K nodes exist, reverse them, then recurse on rest.
    // -------------------------------------------------------
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes remaining
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        if (count < k) return head; // less than k nodes → don't reverse

        // Reverse k nodes
        ListNode prev = null, curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is now the tail of the reversed group → connect to next group
        head.next = reverseKGroup(curr, k);

        return prev; // prev is the new head of the reversed group
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
        // Full Reverse
        print(reverse(build(new int[]{1, 2, 3, 4, 5})));
        // Output: 5 -> 4 -> 3 -> 2 -> 1 -> null

        // Reverse Sublist (left=2, right=4)
        print(reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 2, 4));
        // Output: 1 -> 4 -> 3 -> 2 -> 5 -> null

        // Reverse K-Group (K=2)
        print(reverseKGroup(build(new int[]{1, 2, 3, 4, 5}), 2));
        // Output: 2 -> 1 -> 4 -> 3 -> 5 -> null
    }
}
