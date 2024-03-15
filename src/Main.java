public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll= new DoublyLinkedList(7);


        System.out.println("*********Append****");
        dll.append(1);
        dll.append(8);
        dll.append(2);
        dll.append(9);
        dll.append(3);
        dll.append(10);

        dll.printList();

        System.out.println("******* Remove index");
        System.out.println("removed="+dll.remove(17));
        dll.printList();

        System.out.println("*******");


        System.out.println("*******Get by index");
        System.out.println(dll.get(4).value);


        System.out.println("*********Remove Last****");
        System.out.println("removed node's value="+dll.removeLast().value);
        dll.printList();

        System.out.println("*******");
        System.out.println("head="+dll.getHead().value);
        System.out.println("tail="+dll.getTail().value);
        System.out.println("tail="+dll.getLength());
    }
}
