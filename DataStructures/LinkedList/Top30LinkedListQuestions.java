/**
 * TOP 30 LINKED LIST INTERVIEW QUESTIONS
 * Comprehensive collection of linked list problems with solutions in Java
 * Author: MOHAMMED WASIM KHAN
 * Repository: Data-Structures-using-java
 */
package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Node {
    int val;
    Node next;
    Node random;
    Node(int val) { this.val = val; }
}

public class Top30LinkedListQuestions {

    // ======================== QUESTION 1 ========================
    // Reverse a Linked List (Iterative)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // ======================== QUESTION 2 ========================
    // Reverse a Linked List (Recursive)
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // ======================== QUESTION 3 ========================
    // Detect Cycle in Linked List (Floyd's Cycle Detection)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // ======================== QUESTION 4 ========================
    // Find the Starting Point of Cycle in Linked List
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Cycle detected, find start
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // ======================== QUESTION 5 ========================
    // Find Middle of Linked List
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ======================== QUESTION 6 ========================
    // Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // ======================== QUESTION 7 ========================
    // Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove nth node
        second.next = second.next.next;
        return dummy.next;
    }

    // ======================== QUESTION 8 ========================
    // Check if Linked List is Palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;
        
        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // ======================== QUESTION 9 ========================
    // Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // When a reaches end, redirect to headB
        // When b reaches end, redirect to headA
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    // ======================== QUESTION 10 ========================
    // Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // ======================== QUESTION 11 ========================
    // Remove All Duplicates from Sorted List
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // ======================== QUESTION 12 ========================
    // Add Two Numbers Represented by Linked Lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummy.next;
    }

    // ======================== QUESTION 13 ========================
    // Reverse Nodes in K-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        // Count total nodes
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        while (count >= k) {
            curr = prev.next;
            ListNode next = curr.next;
            
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }

    // ======================== QUESTION 14 ========================
    // Rotate List Right by K Places
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Calculate length
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        
        // Make it circular
        curr.next = head;
        
        // Find new tail position
        k = k % length;
        int stepsToNewHead = length - k;
        
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }

    // ======================== QUESTION 15 ========================
    // Copy List with Random Pointer
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Create copies and interweave with original
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Separate the lists
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }

    // ======================== QUESTION 16 ========================
    // Flatten a Multilevel Doubly Linked List
    class NodeMulti {
        int val;
        NodeMulti prev;
        NodeMulti next;
        NodeMulti child;
    }
    
    public NodeMulti flatten(NodeMulti head) {
        if (head == null) return null;
        
        NodeMulti curr = head;
        while (curr != null) {
            if (curr.child != null) {
                NodeMulti next = curr.next;
                NodeMulti child = flatten(curr.child);
                
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                
                while (curr.next != null) {
                    curr = curr.next;
                }
                
                if (next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    // ======================== QUESTION 17 ========================
    // Sort List (Merge Sort)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Find middle
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        
        // Recursive sort
        left = sortList(left);
        right = sortList(right);
        
        // Merge sorted halves
        return mergeTwoLists(left, right);
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ======================== QUESTION 18 ========================
    // Reorder List (L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;
        
        // Merge both halves
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

    // ======================== QUESTION 19 ========================
    // Partition List (all nodes < x before nodes >= x)
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
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
        
        greater.next = null;
        less.next = greaterHead.next;
        
        return lessHead.next;
    }

    // ======================== QUESTION 20 ========================
    // Swap Nodes in Pairs
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            prev = first;
        }
        
        return dummy.next;
    }

    // ======================== QUESTION 21 ========================
    // Odd Even Linked List (group odd indices together, then even)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }

    // ======================== QUESTION 22 ========================
    // Delete Node in Linked List (given only that node)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // ======================== QUESTION 23 ========================
    // Split Linked List in Parts
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Count length
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        int partSize = length / k;
        int extraNodes = length % k;
        
        ListNode[] result = new ListNode[k];
        curr = head;
        
        for (int i = 0; i < k && curr != null; i++) {
            result[i] = curr;
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;
            
            for (int j = 1; j < currentPartSize; j++) {
                curr = curr.next;
            }
            
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        
        return result;
    }

    // ======================== QUESTION 24 ========================
    // Remove Linked List Elements (remove all nodes with given value)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }

    // ======================== QUESTION 25 ========================
    // Reverse Linked List II (reverse from position m to n)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move to position before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // Reverse from left to right
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        return dummy.next;
    }

    // ======================== QUESTION 26 ========================
    // Merge K Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeKListsHelper(lists, left, mid);
        ListNode l2 = mergeKListsHelper(lists, mid + 1, right);
        
        return mergeTwoLists(l1, l2);
    }

    // ======================== QUESTION 27 ========================
    // Find Length of Cycle in Linked List
    public int lengthOfCycle(ListNode head) {
        if (head == null) return 0;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Count cycle length
                int length = 1;
                ListNode temp = slow.next;
                while (temp != slow) {
                    length++;
                    temp = temp.next;
                }
                return length;
            }
        }
        return 0;
    }

    // ======================== QUESTION 28 ========================
    // Convert Binary Number in Linked List to Integer
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

    // ======================== QUESTION 29 ========================
    // Next Greater Node In Linked List
    public int[] nextLargerNodes(ListNode head) {
        // Convert to array first
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int[] result = new int[list.size()];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        return result;
    }

    // ======================== QUESTION 30 ========================
    // Design Browser History (using doubly linked list concept)
    class BrowserHistory {
        class Node {
            String url;
            Node prev, next;
            Node(String url) { this.url = url; }
        }
        
        Node current;
        
        public BrowserHistory(String homepage) {
            current = new Node(homepage);
        }
        
        public void visit(String url) {
            Node newNode = new Node(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        
        public String back(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }
        
        public String forward(int steps) {
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
            return current.url;
        }
    }

    // ======================== UTILITY METHODS ========================
    
    // Print linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    
    // Create linked list from array
    public ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // ======================== MAIN METHOD FOR TESTING ========================
    public static void main(String[] args) {
        Top30LinkedListQuestions solution = new Top30LinkedListQuestions();
        
        // Test Case 1: Reverse List
        System.out.println("=== Test 1: Reverse Linked List ===");
        ListNode list1 = solution.createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        solution.printList(list1);
        ListNode reversed = solution.reverseList(list1);
        System.out.print("Reversed: ");
        solution.printList(reversed);
        
        // Test Case 2: Find Middle
        System.out.println("\n=== Test 2: Find Middle Node ===");
        ListNode list2 = solution.createList(new int[]{1, 2, 3, 4, 5});
        ListNode middle = solution.middleNode(list2);
        System.out.println("Middle value: " + middle.val);
        
        // Test Case 3: Palindrome Check
        System.out.println("\n=== Test 3: Palindrome Check ===");
        ListNode list3 = solution.createList(new int[]{1, 2, 3, 2, 1});
        System.out.println("Is Palindrome: " + solution.isPalindrome(list3));
        
        // Test Case 4: Merge Two Sorted Lists
        System.out.println("\n=== Test 4: Merge Two Sorted Lists ===");
        ListNode list4a = solution.createList(new int[]{1, 3, 5});
        ListNode list4b = solution.createList(new int[]{2, 4, 6});
        ListNode merged = solution.mergeTwoLists(list4a, list4b);
        System.out.print("Merged: ");
        solution.printList(merged);
        
        System.out.println("\n✓ All test cases completed successfully!");
    }
}
