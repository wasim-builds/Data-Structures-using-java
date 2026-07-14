package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListUserInput {
    Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at a given position
    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < pos - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) return;
        head = head.next;
    }

    // Delete at the end
    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Delete at a given position
    public void deleteAtPosition(int pos) {
        if (head == null) return;

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < pos - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        current.next = current.next.next;
    }

    // Print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to interact with user
    public static void main(String[] args) {
        LinkedListUserInput list = new LinkedListUserInput();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            int data, pos;

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter value to insert: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter value to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    pos = scanner.nextInt();
                    list.insertAtPosition(data, pos);
                    break;

                case 4:
                    list.deleteAtBeginning();
                    break;

                case 5:
                    list.deleteAtEnd();
                    break;

                case 6:
                    System.out.print("Enter position to delete: ");
                    pos = scanner.nextInt();
                    list.deleteAtPosition(pos);
                    break;

                case 7:
                    list.printList();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}

