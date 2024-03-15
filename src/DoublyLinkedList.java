public class DoublyLinkedList {
    private int length;
    private Node head;
    private Node tail;

    DoublyLinkedList(int value){
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length++;
    }

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    class Node{
        public int value;
        private Node next;
        private Node prev;
        Node(int value){
            this.value=value;
        }
    }
    //append
    public void append(int value){
        Node appendedNode=new Node(value);
        //when we have empty list
        if(length==0){
            head=appendedNode;
            tail=appendedNode;
        }else {
            Node oldNode=tail;
            oldNode.next=appendedNode;
            appendedNode.prev=oldNode;
            tail=appendedNode;
        }
        length++;
    }
    //remove last
    public Node removeLast(){
        Node temp=tail;
        //if we have empty Node
        if (length==0){
            return null;
        }else if(length==1) {
            //if we have one item
            head=null;
            tail=null;
        }else {
            //multiple nodes
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        length--;
        return temp;
    }
    public void prepend(int value){
        Node newNode= new Node(value);
        //if list is empty
        if (length==0){
            head=newNode;
            tail=newNode;
        }else {
            //if list have data
            Node temp=head;
            head=newNode;
            newNode.next=temp;
            temp.prev=newNode;
        }
        length++;
    }

    public Node removeFirst(){
        Node temp=head;
        if (length==0){
            return null;
        }else if(length==1){
            head=null;
            tail=null;
        }else{
            head=head.next;
            temp.next=null;
            head.prev=null;

        }
        length--;
        return temp;
    }

    public Node get(int index){

        if (index<0 || index >length){
            return null;
        }
        if (index < length/2){
            Node temp=head;
            //start from head
            for (int i=0; i<index; i++){
                temp=temp.next;
            }
            return temp;
        }else{
            //Node temp=head;
            //start from tail
            Node temp=tail;
            for (int i=index; i>=index; i--){
                temp=temp.prev;
            }
            return temp;
        }
    }

    public boolean set(int index, int value){
        Node temp=get(index);
        if (temp==null){
            return false;
        }

        temp.value=value;

        return true;
    }

    public boolean insert (int index, int value){
        //insertion for empty list (it will be handled by insertion by first node, because we are going to use append method)
        //insertion at first node
        //insertion at last index
        //insertion at any index
        //edge case : index should not be negative are greater than length of the list
        if(index < 0 || index > length) return false;

        if (index==0){
            prepend(value);
            return true;
        }
        if(index==length){
            append(value);
            return true;
        }
            Node newNode= new Node(value);
            Node temp=get(index);
            if (temp==null){return false;}
            Node beforeTemp=temp.prev;
            beforeTemp.next=newNode;
            temp.prev=newNode;
            newNode.prev=beforeTemp;
            newNode.next=temp;
            length++;
            return true;

    }

    public Node remove(int index){
        //remove from first node
        //remove from last node
        //remove from end of the node
        //edge case: index should not be greater than size of list or less than zero
        if (index < 0 || index >= length) return null;
        if (index==0){
            return removeFirst();
        }
        if (index==length-1){
            return removeLast();
        }
        Node temp=get(index);
        Node after=temp.next;
        Node before=temp.prev;
        temp.prev=null;
        temp.next=null;
        after.prev=before;
        before.next=after;
        length--;


        return temp;

    }




    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

}

