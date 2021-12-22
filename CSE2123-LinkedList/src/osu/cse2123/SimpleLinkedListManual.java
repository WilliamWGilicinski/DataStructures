package osu.cse2123;

/**
 * A manual implementation of the SimpledLinkedList class
 *
 * @author William Gilicinski
 * @version April 14, 2021
 */

public class SimpleLinkedListManual<E> implements SimpleLinkedList<E> {

    private class Node {
        E element;
        Node next;
    }

    private Node front;
    private Node back;
    private int size;

    /**
     * Creates an empty linked list
     */
    public SimpleLinkedListManual() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public void addFront(E element) {
        Node temp = new Node();
        temp.element = element;
        //If the list is empty, update the front and back to point to the new
        //element
        if (this.size == 0) {
            temp.next = null;
            this.front = temp;
            this.back = temp;
            this.size++;
            //If the list is not empty, set the new front
        } else {
            temp.next = this.front;
            this.front = temp;
            this.size++;
        }

    }

    @Override
    public E removeFront() {
        E generic;
        //If the list is of size one, make the list empty with front and back
        //null.
        if (this.size == 1) {
            generic = this.front.element;
            this.front = null;
            this.back = null;
            this.size--;
            //Else make the 2nd element the front of the list.
        } else {
            generic = this.front.element;
            this.front = this.front.next;
            this.size--;
        }
        return generic;
    }

    @Override
    public void addEnd(E element) {
        Node temp = new Node();
        temp.element = element;
        temp.next = null;
        //Same process as add front where if the list is empty, both the front
        //and back pointers will point to the same node.
        if (this.size == 0) {
            this.front = temp;
            this.back = temp;
            this.size++;
            //else only point the back pointer to the node and update the current
            //back node to point to the one being added.
        } else {
            this.back.next = temp;
            this.back = temp;
            this.size++;
        }
    }

    @Override
    public E removeEnd() {
        E generic;
        Node pointer = new Node();
        pointer = this.front;

        //If the list is of size one, makes the front and back pointer null
        if (this.size == 1) {
            generic = pointer.element;
            this.front = null;
            this.back = null;
            this.size--;
            //if the list is a size greater of size one, iterate over the list
            //with a pointer until the second to last element is found. That
            //elements next pointer is set to null and the back pointer of the
            //list now points to the second to last element.
        } else {
            for (int i = 0; i < this.size - 2; i++) {
                pointer = pointer.next;
            }
            generic = this.back.element;
            pointer.next = null;
            this.back = pointer;
            this.size--;
        }

        return generic;
    }

    @Override
    public E front() {
        return this.front.element;
    }

    @Override
    public E end() {
        return this.back.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String output = "< ";
        Node pointer = new Node();
        pointer = this.front;
        //Iterates through the list and adds their element to a string.
        for (int i = 0; i < this.size; i++) {
            output += pointer.element + " ";
            if (i + 1 < this.size) {
                pointer = pointer.next;
            }
        }
        output += ">";
        return output;
    }

    @Override
    public int hashCode() {
        int value = 0;
        if (this.size > 0) {
            Node pointer = new Node();
            pointer = this.front;
            //Adds up the hashcode values of the elements and adds their
            //position so that two lists with the same elements in a different
            //order don't equal each other
            for (int i = 0; i < this.size; i++) {
                value += pointer.element.hashCode() + i;
                if (i + 1 < this.size) {
                    pointer = pointer.next;
                }
            }
        }
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        //Checks to see if the memory location is the same
        if (this == obj) {
            equals = true;
            //If its not make a linked list object out of obj if obj is an
            //instance of linked list and compare hashcode
        } else if (obj instanceof SimpleLinkedListManual<?>) {
            SimpleLinkedListManual<?> localObj = (SimpleLinkedListManual<?>) obj;
            equals = this.hashCode() == localObj.hashCode();
        }
        return equals;
    }

}
