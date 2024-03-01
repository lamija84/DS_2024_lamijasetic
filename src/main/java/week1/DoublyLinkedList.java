package week1;

import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(Data data) {
        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next = head;
            head.prev=newNode;
            head=newNode;

        }
        size++;
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {

        if(head==null){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(Data data) {

        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        if(head == null){
            head = newNode;
            size++;
        }
        else{
            DoubleNode<Data> current = head;
            while(current.next!=null){
                current=current.next;
            }

            newNode.prev = current;
            tail = newNode;
            current.next = newNode;

            size++;
        }
    }

    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {


        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        } else if (size == 1) {                                                 // 2
            head = null;                                                        // 2
        } else {                                                                // 3
            DoubleNode<Data> current = head;                                          // 3
            while (current.next.next != null) {                                 // 4
                current = current.next;                                         // 4
            }                                                                   // 4
            current.next = null;                                                // 5
        }
        size--;
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {

        if (index <0 || index>=size){
            throw new IndexOutOfBoundsException("Invalid index value");
        }

        DoubleNode<Data> current = head;

        if(index!=0){
            int i = 0;
            while(i < index){
                current = current.next;
                i++;
            }
        }

        return current.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        DoubleNode<Data> current = head;
        DoubleNode<Data> temp = new DoubleNode<>();
        int i = 0;																// 3
        while (i < index) {                                                     // 4
            temp = current;
            current = current.next;												// 4
            i++;																// 4
        }

        newNode.next = current;
        newNode.prev = current.prev;
        temp.next = newNode;
        size++;
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        DoubleNode<Data> current = head;
        DoubleNode<Data> previous = new DoubleNode<>();
        int i = 0;																// 3
        while (i < index) {                                                     // 4
            previous = current;
            current = current.next;												// 4
            i++;																// 4
        }

        previous.next = current.next;
        current.next.prev = previous;
        size++;
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        //your code
        return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() {
        return new DoublyLinkedListIterator();
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {
        DoubleNode<Data> current = head;                                      // 2

        public boolean hasNext() {                                      // 3
            return current != null;                                     // 3
        }                                                               // 3

        public Data next() {                                            // 4
            Data data = current.data;                                   // 4
            current = current.next;                                     // 4
            return data;                                                // 4
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<Data> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<Data> getTail() {
        return tail;
    }
}