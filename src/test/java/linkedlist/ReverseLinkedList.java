package linkedlist;

/**
 * LinkedList = 1 > 2 > 3 > 4 > 5
 * Result: 5 > 4 > 3 > 2 > 1
 */
public class ReverseLinkedList {


    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;


        for(int i = 2; i < 5; i++){
            current.setNext(new Node(i));
            current = current.getNext();
        }
        printNodes(head);
        current = reverseList(head);
        printNodes(current);
    }

    private static Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    private static void printNodes(Node head){
        System.out.println("Print Nodes...");
        System.out.println("**********************");
        Node current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("**********************");
    }

}
