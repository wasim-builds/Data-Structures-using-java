/**
 * ============================================================
 * LINKED LIST — SLOW & FAST POINTERS (Tortoise & Hare)
 * ============================================================
 *
 * PATTERN IDEA:
 * Use two pointers — one moves 1 step at a time (slow),
 * the other moves 2 steps at a time (fast).
 *
 * This gap between them reveals powerful properties:
 *  - When fast reaches the END  → slow is at the MIDDLE
 *  - When fast MEETS slow again → there is a CYCLE
 *
 * PROBLEMS COVERED:
 *  1. Find the Middle of a Linked List
 *  2. Detect Cycle in a Linked List
 *  3. Find the Start Node of the Cycle
 *  4. Check if Linked List is a Palindrome
 * ============================================================
 */
public class LL_SlowFastPointers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // -------------------------------------------------------
    // PROBLEM 1: Find the Middle of a Linked List
    // Input:  1 -> 2 -> 3 -> 4 -> 5
    // Output: Node with value 3
    //
    // HOW: When fast reaches the end, slow is exactly in the middle.
    // -------------------------------------------------------
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // 1 step
            fast = fast.next.next;  // 2 steps
        }
        return slow; // slow is at the middle
    }

    // -------------------------------------------------------
    // PROBLEM 2: Detect Cycle in a Linked List
    // If fast and slow ever point to the same node → cycle exists
    // -------------------------------------------------------
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // they met → cycle!
        }
        return false;
    }

    // -------------------------------------------------------
    // PROBLEM 3: Find the Start of the Cycle
    // TRICK: After slow and fast meet inside the cycle,
    //        reset one pointer to head. Move both 1 step at a time.
    //        They will meet EXACTLY at the cycle start node!
    // -------------------------------------------------------
    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head, fast = head;
        boolean cycleExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { cycleExists = true; break; }
        }

        if (!cycleExists) return null;

        slow = head; // reset slow to head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next; // BOTH move 1 step now
        }
        return slow; // meeting point = cycle start
    }

    // -------------------------------------------------------
    // PROBLEM 4: Check if Linked List is a Palindrome
    // APPROACH:
    //   Step 1: Find the middle using slow/fast pointers
    //   Step 2: Reverse the second half of the list
    //   Step 3: Compare first half and reversed second half
    // -------------------------------------------------------
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half from 'slow'
        ListNode secondHalfHead = reverse(slow);
        ListNode copySecondHead = secondHalfHead; // save for restoring

        // Step 3: Compare
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) { result = false; break; }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(copySecondHead); // restore the list (good practice)
        return result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // --- Helper: Build list from array ---
    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = build(new int[]{1, 2, 3, 4, 5});
        System.out.println("Middle: " + findMiddle(list).val);     // 3

        System.out.println("Has Cycle: " + hasCycle(list));         // false

        ListNode pal = build(new int[]{1, 2, 3, 2, 1});
        System.out.println("Is Palindrome: " + isPalindrome(pal));  // true
    }
}
