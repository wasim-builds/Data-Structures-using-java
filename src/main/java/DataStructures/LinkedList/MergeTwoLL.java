package LinkedList;



class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeTwoLL {

    // Merge two sorted linked lists
    public static Node mergeSortedLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        tail.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }

    // Print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Create linked list from array
    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Assume the input lists are already sorted
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        Node list1 = createList(arr1);
        Node list2 = createList(arr2);

        Node mergedHead = mergeSortedLists(list1, list2);

        System.out.println("Merged Sorted Linked List:");
        printList(mergedHead);
    }
}
