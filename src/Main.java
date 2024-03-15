public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll= new DoublyLinkedList(7);


        System.out.println("*********Append****");
        dll.append(1);
        dll.append(8);
        dll.append(2);

        dll.printList();

        System.out.println("*********Remove Last****");
        System.out.println("removed node's value="+dll.removeLast().value);
        dll.printList();

        System.out.println("*******");
        System.out.println("head="+dll.getHead().value);
        System.out.println("tail="+dll.getTail().value);
        System.out.println("tail="+dll.getLength());
    }
}
