/**
 * ============================================================
 * LINKED LIST — TWO POINTERS
 * ============================================================
 *
 * PATTERN IDEA:
 * Use two pointers that start at different positions OR move
 * at different offsets to solve problems in a single pass O(N).
 *
 * Unlike slow/fast, here both pointers move at the SAME speed
 * but one starts ahead of the other (a gap/offset between them).
 *
 * PROBLEMS COVERED:
 *  1. Remove Nth Node from End of List
 *  2. Find the Intersection Point of Two Linked Lists
 *  3. Remove Duplicates from Sorted Linked List
 *  4. Partition List around a value X
 * ============================================================
 */
public class LL_TwoPointers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // -------------------------------------------------------
    // PROBLEM 1: Remove Nth Node from End of List
    // Input:  1 -> 2 -> 3 -> 4 -> 5,  N = 2
    // Output: 1 -> 2 -> 3 -> 5
    //
    // TRICK: Move 'fast' N steps ahead first.
    //        Then move both slow and fast together.
    //        When fast reaches null, slow is exactly at the node BEFORE the one to delete.
    // -------------------------------------------------------
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) fast = fast.next;

        // Move both until fast is null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now just before the node to delete
        slow.next = slow.next.next;
        return dummy.next;
    }

    // -------------------------------------------------------
    // PROBLEM 2: Find Intersection of Two Linked Lists
    // Two lists may share a common tail. Find the first shared node.
    //
    // TRICK: If you switch pointers to the other list's head when
    //        they hit null, they will both travel the same total
    //        distance and meet exactly at the intersection!
    //
    // List A: a1 -> a2 -> c1 -> c2
    // List B: b1 -> b2 -> b3 -> c1 -> c2
    // -------------------------------------------------------
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next; // when A ends, redirect to B's head
            b = (b == null) ? headA : b.next; // when B ends, redirect to A's head
        }
        return a; // null if no intersection, node if intersection exists
    }

    // -------------------------------------------------------
    // PROBLEM 3: Remove Duplicates from Sorted Linked List
    // Input:  1 -> 1 -> 2 -> 3 -> 3
    // Output: 1 -> 2 -> 3
    //
    // TRICK: cur pointer scans ahead while a 'prev' pointer
    //        builds the de-duplicated list.
    // -------------------------------------------------------
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next; // skip the duplicate
            } else {
                cur = cur.next; // only advance if no duplicate
            }
        }
        return head;
    }

    // -------------------------------------------------------
    // PROBLEM 4: Partition List around value X
    // All nodes < X come before nodes >= X (preserve relative order)
    // Input:  1 -> 4 -> 3 -> 2 -> 5 -> 2,  X = 3
    // Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
    //
    // TRICK: Build two separate lists — "less" and "greater",
    //        then connect them at the end.
    // -------------------------------------------------------
    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);  // dummy head for < x partition
        ListNode greaterHead = new ListNode(0); // dummy head for >= x partition

        ListNode less = lessHead, greater = greaterHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;         // end the greater list
        less.next = greaterHead.next; // connect less list to greater list
        return lessHead.next;
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
        // Remove Nth from end
        print(removeNthFromEnd(build(new int[]{1,2,3,4,5}), 2));
        // Output: 1 -> 2 -> 3 -> 5 -> null

        // Remove Duplicates
        print(deleteDuplicates(build(new int[]{1,1,2,3,3})));
        // Output: 1 -> 2 -> 3 -> null

        // Partition
        print(partition(build(new int[]{1,4,3,2,5,2}), 3));
        // Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5 -> null
    }
}
