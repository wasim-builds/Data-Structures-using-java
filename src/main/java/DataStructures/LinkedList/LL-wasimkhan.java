package LinkedList;
public class LL {
    static Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        head = head.next; // Automatically removes first node
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null; // Only one node present
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            secondLast = secondLast.next;
            lastNode = lastNode.next;
        }

        secondLast.next = null; // Remove reference to last node
    }

    public boolean search(String key) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data.equals(key)) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("Null");
    }
    public static int getSize(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LL list = new LL();

        list.addFirst("wasim");
        list.addLast("khan");
        list.printList(); // wasim -> khan -> Null

        list.deleteFirst();
        list.printList(); // khan -> Null

        list.addLast("ahmed");
        list.printList(); // khan -> ahmed -> Null

        list.deleteLast();
        list.printList(); // khan -> Null

        System.out.println("Search 'khan': " + list.search("khan")); // true
        System.out.println("Search 'wasim': " + list.search("wasim")); // false
        System.out.println(getSize(head));
        list.printList();
        
    }
}
